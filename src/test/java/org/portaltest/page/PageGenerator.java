package org.portaltest.page;

public interface PageGenerator {
    <TPage extends PageGenerator> TPage getInstance(Class<TPage> pageClass);
}
