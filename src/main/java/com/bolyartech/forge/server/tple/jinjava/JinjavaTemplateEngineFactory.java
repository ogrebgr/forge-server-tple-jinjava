package com.bolyartech.forge.server.tple.jinjava;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.loader.ClasspathResourceLocator;


public class JinjavaTemplateEngineFactory implements TemplateEngineFactory {
    private final String mTemplatePathPrefix;
    private final Jinjava mJinjava;


    public JinjavaTemplateEngineFactory(String templatePathPrefix, Jinjava jinjava) {
        mTemplatePathPrefix = templatePathPrefix;
        mJinjava = jinjava;
    }


    public JinjavaTemplateEngineFactory(String templatePathPrefix) {
        mTemplatePathPrefix = templatePathPrefix;
        mJinjava = new Jinjava();
        mJinjava.setResourceLocator(new ClasspathResourceLocator());
    }


    @Override
    public TemplateEngine createNew() {
        return new JinjavaTemplateEngine(mTemplatePathPrefix, mJinjava);
    }
}
