package com.quilleash.arkhamlcg.metadata.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Folder extends Item {
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Folder getSubFolder(String subFolderName) {
        return items.stream()
                .filter(o -> o instanceof Folder)
                .map(o -> (Folder)o)
                .filter(o -> o.getName().equals(subFolderName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No sub-folder with name" + subFolderName + " found"));
    }

    public List<Folder> getSubFolders() {
        return items.stream()
                .filter(o -> o instanceof Folder)
                .map(o -> (Folder)o)
                .collect(Collectors.toList());
    }

    public FolderSearch createFolderSearch() {
        return new FolderSearchImpl(getCards());
    }

    public FolderSearch createFolderSearchAncestors() {
        return new FolderSearchImpl(getCardsAncestors());
    }

    public List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Card)
                cards.add((Card)item);
        }
        return cards;
    }

    private List<Card> getCardsAncestors() {
        List<Card> cards = new ArrayList<>(getCards());
        for (Item item : items) {
            if (item instanceof Folder)
                cards.addAll(((Folder)item).getCardsAncestors());
        }

        return cards;
    }

    public interface FolderSearch {
        List<Card> getAllCards();

        Card getCard(String name);

        <T extends CardFace> Card getCard(String name, Class<T> frontFaceClass);

        <T extends CardFace> List<T> getCardFaceOfFrontFaceType(Class<T> clazz);

        <T extends CardFace> List<Card> getCardsOfFrontFaceType(Class<T> frontFaceClass);

        // returns a list of act cards, in order, for an a/b act deck
        // if no matching cards are found an exception is thrown
        List<Card> getDefaultActDeck();

        // return a list of act cards, in order, for the given deck id
        // only 'front' face letters are valid, for example 'a', 'c', 'e'
        List<Card> getActDeck(char deckId);

        // returns a list of agenda cards, in order, for an a/b deck
        // if no matching cards are found an exception is thrown
        List<Card> getDefaultAgendaDeck();

        // return a list of agenda cards, in order, for the given deck id
        // only 'front' face letters are valid, for example 'a', 'c', 'e'
        List<Card> getAgendaDeck(char deckId);

        Card getChaosTokenCard();
    }

    private static class FolderSearchImpl implements FolderSearch {
        private final List<Card> cards;

        public FolderSearchImpl(List<Card> cards) {
            this.cards = cards;
        }

        @Override
        public List<Card> getAllCards() {
            return cards;
        }

        public Card getCard(String name) {
            List<Card> cards = getAllCards().stream()
                    .filter(o -> o.getName().equals(name))
                    .collect(Collectors.toList());

            if (cards.size() > 1)
                throw new RuntimeException("Found multiple cards matching name: " + name);

            if (cards.size() == 0)
                throw new RuntimeException("Found no cards matching name: " + name);

            return cards.get(0);
        }

        @Override
        public <T extends CardFace> Card getCard(String name, Class<T> frontFaceClass) {
            List<Card> cards = getAllCards().stream()
                    .filter(o -> o.getName().equals(name) && frontFaceClass.isInstance(o.getFrontFace()))
                    .collect(Collectors.toList());

            if (cards.size() > 1)
                throw new RuntimeException("Found multiple cards matching name: " + name);

            if (cards.size() == 0)
                throw new RuntimeException("Found no cards matching name: " + name);

            return cards.get(0);
        }

        @Override
        public <T extends CardFace> List<Card> getCardsOfFrontFaceType(Class<T> frontFaceClass) {
            return getAllCards().stream()
                    .filter(o -> frontFaceClass.isInstance(o.getFrontFace()))
                    .collect(Collectors.toList());
        }

        public <T extends CardFace> List<T> getCardFaceOfFrontFaceType(Class<T> clazz) {
            return getAllCards().stream()
                    .filter(o -> clazz.isInstance(o.getFrontFace()))
                    .map(o -> clazz.cast(o.getFrontFace()))
                    .collect(Collectors.toList());
        }

        @Override
        public List<Card> getDefaultActDeck() {
            return getActDeck('a');
        }

        @Override
        public List<Card> getActDeck(char deckId) {
            List<Card> cards = getCardsOfFrontFaceType(Act.class).stream()
                    .filter(o -> ((Act)o.getFrontFace()).getDeckId() == deckId) // use the front face deck id to filter only 'a' cards
                    .sorted(Comparator.comparingInt(o -> ((Act)o.getFrontFace()).getIndex()))
                    .collect(Collectors.toList());

            if (cards.isEmpty())
                throw new RuntimeException("No act cards found matching deck id: " + deckId);

            return cards;
        }

        @Override
        public List<Card> getDefaultAgendaDeck() {
            return getAgendaDeck('a');
        }

        @Override
        public List<Card> getAgendaDeck(char deckId) {
            List<Card> cards = getCardsOfFrontFaceType(Agenda.class).stream()
                    .filter(o -> ((Agenda)o.getFrontFace()).getDeckId() == deckId) // use the front face deck id to filter only 'a' cards
                    .sorted(Comparator.comparingInt(o -> ((Agenda)o.getFrontFace()).getIndex()))
                    .collect(Collectors.toList());

            if (cards.isEmpty())
                throw new RuntimeException("No agenda cards found matching deck id: " + deckId);

            return cards;
        }

        @Override
        public Card getChaosTokenCard() {
            List<Card> cards = getCardsOfFrontFaceType(Chaos.class);

            if (cards.size() > 1)
                throw new RuntimeException("Found multiple cards with a chaos token front face");

            if (cards.size() == 0)
                throw new RuntimeException("Found no cards with a chaos token front face");

            return cards.get(0);
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
