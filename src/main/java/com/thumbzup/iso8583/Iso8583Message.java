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

public interface Iso8583Message {

    void setField(int no, String value) throws Iso8583Exception;

    void setField(String path, String value) throws Iso8583Exception;

    void setField(int no, byte[] value) throws Iso8583Exception;

    void setField(String path, byte[] value) throws Iso8583Exception;

    int getMaxField();

    byte[] encode() throws Iso8583Exception;

    boolean isNetworkMessage() throws Iso8583Exception;

    boolean hasField(int no);

    boolean hasPathField(String path) throws Iso8583Exception;

    Object getFieldValue(int no) throws Iso8583Exception;

    Object getFieldValue(String path) throws Iso8583Exception;

    String getMessageType() throws Iso8583Exception;

    String getFieldValueAsString(int no);

    String getFieldValueAsString(String path) throws Iso8583Exception;

    byte[] getFieldValueAsEncoded(int no) throws Iso8583Exception;

    byte[] getFieldValueAsEncoded(String path) throws Iso8583Exception;

    String getFieldDescription(int no) throws Iso8583Exception;

    String getFieldDescription(String path) throws Iso8583Exception;

    byte[] getFieldValueAsBytes(int no);

    byte[] getFieldValueAsBytes(String path);

    void setResponseMessageType() throws Iso8583Exception;

    void setRetransmissionMessageType() throws Iso8583Exception;
}
