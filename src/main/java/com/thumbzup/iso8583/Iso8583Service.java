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

public interface Iso8583Service {
    Iso8583Message create(String mti, byte[] header, AcquirerProtocol protocol);

    Iso8583Message parse(byte[] isodata, int headerLength, AcquirerProtocol protocol) throws Iso8583Exception;

    boolean supports(AcquirerProtocol protocol);
}
