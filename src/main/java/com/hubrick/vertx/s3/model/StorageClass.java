/**
 * Copyright (C) 2016 Etaia AS (oss@hubrick.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubrick.vertx.s3.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Emir Dizdarevic
 * @since 3.0.0
 */
@XmlType
@XmlEnum(String.class)
public enum StorageClass {
    @XmlEnumValue("STANDARD") STANDARD,
    @XmlEnumValue("STANDARD_IA") STANDARD_IA,
    @XmlEnumValue("REDUCED_REDUNDANCY") REDUCED_REDUNDANCY;

    private static Map<String, StorageClass> REVERSE_LOOKUP = new HashMap<>();
    static {
        for(StorageClass storageClass : values()) {
            REVERSE_LOOKUP.put(storageClass.name(), storageClass);
        }
    }

    public static StorageClass fromString(String value) {
        return REVERSE_LOOKUP.get(value);
    }

    @Override
    public String toString() {
        return name();
    }
}
