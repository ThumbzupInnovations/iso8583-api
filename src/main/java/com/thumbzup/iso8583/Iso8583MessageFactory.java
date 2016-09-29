/*
 *     Copyright (C) 2016 Sean
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.thumbzup.iso8583;

import com.thumbzup.iso8583.exception.Iso8583Exception;

import java.util.ServiceLoader;

public class Iso8583MessageFactory {

    private static final ServiceLoader<Iso8583Service> serviceList = ServiceLoader.load(Iso8583Service.class);

    public static Iso8583Message create(String mti, byte[] header, AcquirerProtocol protocol) {
        return getService(protocol).create(mti, header, protocol);
    }

    public static Iso8583Message parse(byte[] isodata, AcquirerProtocol protocol, int headerLength) throws Iso8583Exception {
        return getService(protocol).parse(isodata, headerLength, protocol);
    }

    private static Iso8583Service getService(AcquirerProtocol protocol) {
        for (Iso8583Service iso8583Service : serviceList) {
            if (iso8583Service.supports(protocol)) {
                return iso8583Service;
            }
        }
        throw new RuntimeException("No services implementations found for " + Iso8583MessageFactory.class + " and protocol " + protocol);
    }
}
