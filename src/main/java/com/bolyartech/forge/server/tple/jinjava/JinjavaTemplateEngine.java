package com.bolyartech.forge.server.tple.jinjava;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class JinjavaTemplateEngine implements TemplateEngine {
    private final Map<String, Object> mAttributes = new HashMap<>();
    private final String mTemplatePathPrefix;
    private final Jinjava mJinjava;


    public JinjavaTemplateEngine(String templatePathPrefix, Jinjava jinjava) {
        mTemplatePathPrefix = templatePathPrefix;
        mJinjava = jinjava;
    }


    @Override
    public void assign(String varName, Object object) {
        mAttributes.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        try {
            String template = Resources.toString(Resources.getResource(mTemplatePathPrefix + templateName),
                    Charsets.UTF_8);

            return mJinjava.render(template, mAttributes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
