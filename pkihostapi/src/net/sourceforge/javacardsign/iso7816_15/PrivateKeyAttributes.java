/*
 * Java Card PKI host API - A Java API for accessing ISO7816
 * compliant PKI cards. 
 *
 * Copyright (C) 2009 Wojciech Mostowski, woj@cs.ru.nl
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */

package net.sourceforge.javacardsign.iso7816_15;

import java.io.InputStream;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/** 
 * A structure to store ISO7816-15 PrivateKeyAttributes objects.
 * Does not yet fully implement the specification.
 * @author Wojciech Mostowski <woj@cs.ru.nl>
 *
 */
public class PrivateKeyAttributes {

    private byte[] keyId;

    public PrivateKeyAttributes(byte[] keyId) {
        this.keyId = keyId;
    }

    public PrivateKeyAttributes(InputStream in) {
        throw new NotImplementedException();
    }

    public DERObject getDERObject() {
        DERInteger idType = new DERInteger(4);
        DEROctetString id = new DEROctetString(this.keyId);
        return new DERSequence(new ASN1Encodable[] { idType, id });
    }

}
