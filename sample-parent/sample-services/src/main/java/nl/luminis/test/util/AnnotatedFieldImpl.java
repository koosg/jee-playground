package nl.luminis.test.util;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Implementation of {@link AnnotatedField} to be used in CDI life cycle events and
 * {@link org.apache.deltaspike.core.util.metadata.builder.AnnotatedTypeBuilder}.
 */
class AnnotatedFieldImpl<X> extends AnnotatedMemberImpl<X, Field> implements AnnotatedField<X>
{

    /**
     * Constructor.
     */
    public AnnotatedFieldImpl(AnnotatedType<X> declaringType, Field field, AnnotationStore annotations,
                              Type overriddenType)
    {
        super(declaringType, field, field.getType(), annotations, field.getGenericType(), overriddenType);
    }

}
