/*
 * Copyright (C) 2015  Hugh Eaves
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.java0.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.function.Supplier;
import java.util.logging.Logger;

import javax.inject.Named;

import org.java0.factory.AbstractConfiguredObjectSupplier;
import org.java0.factory.AbstractDelegableFactory;
import org.java0.factory.FactoryException;
import org.java0.factory.FactoryManager;
import org.java0.tag.HostNameTag;
import org.java0.tag.LocalHostTag;
import org.java0.tag.LocalJVMTag;
import org.java0.tag.NamedTag;
import org.java0.tag.RemoteHostTag;
import org.java0.tag.Tag;

/**
 * Factory that creates Tag objects from object annotations.
 * 
 * @author Hugh Eaves
 *
 */
public class ConverterFactory extends AbstractDelegableFactory {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(ConverterFactory.class.getName());

    static {
        FactoryManager.addDelegate(new ConverterFactory());
    }

    public ConverterFactory() {
        addType(Tag.class, Named.class, new AbstractConfiguredObjectSupplier<Tag, AnnotationTagConfig>(null) {
            @Override
            public Tag get(final AnnotationTagConfig config) throws FactoryException {
                final Named annotation = (Named) config.get0();
                return new NamedTag(annotation.value());
            }
        });
        addType(Tag.class, LocalHost.class, new Supplier<Tag>() {
            @Override
            public Tag get() throws FactoryException {
                return LocalHostTag.INSTANCE;
            }

        });
        addType(Tag.class, LocalJVM.class, new Supplier<Tag>() {
            @Override
            public Tag get() throws FactoryException {
                return LocalJVMTag.INSTANCE;
            }

        });
        addType(Tag.class, RemoteHost.class, new Supplier<Tag>() {
            @Override
            public Tag get() throws FactoryException {
                return RemoteHostTag.INSTANCE;
            }

        });
        addType(Tag.class, HostName.class, new AbstractConfiguredObjectSupplier<Tag, AnnotationTagConfig>(null) {
            @Override
            public Tag get(final AnnotationTagConfig config) throws FactoryException {
                final HostName annotation = (HostName) config.get0();
                return new HostNameTag(annotation.value());
            }
        });
    }

    public static Tag convertAnnotations(final AnnotatedElement element) {
        Tag firstTag = null;
        final Annotation[] annotations = element.getAnnotations();
        for (final Annotation annotation : annotations) {
            final Tag newTag = FactoryManager.getRootFactory().getObject(Tag.class, annotation.getClass(),
                    new AnnotationTagConfig(annotation));

            if (newTag != null) {
                if (firstTag != null) {
                    firstTag.link(newTag);
                } else {
                    firstTag = newTag;
                }
            }
        }
        return firstTag;
    }
}
