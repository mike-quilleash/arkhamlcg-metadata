package com.quilleash.arkhamlcg.metadata.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.quilleash.arkhamlcg.metadata.model.Metadata;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ArkhamLcgMetadataUtils {
    public static Metadata loadMetadata(Reader reader) throws IOException  {
        return new ObjectMapper().readValue(reader, Metadata.class);
    }

    public static void saveMetadata(Writer writer, Metadata metadata) throws IOException  {
        new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValue(writer, metadata);
    }
}
