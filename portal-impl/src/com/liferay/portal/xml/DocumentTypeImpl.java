/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.xml;

import com.liferay.portal.kernel.xml.DocumentType;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentTypeImpl implements DocumentType {

	public DocumentTypeImpl(org.dom4j.DocumentType documentType) {
		_documentType = documentType;
	}

	public String getName() {
		return _documentType.getName();
	}

	public String getPublicId() {
		return _documentType.getPublicID();
	}

	public String getSystemId() {
		return _documentType.getSystemID();
	}

	public org.dom4j.DocumentType getWrappedDocumentType() {
		return _documentType;
	}

	@Override
	public int hashCode() {
		return _documentType.hashCode();
	}

	@Override
	public String toString() {
		return _documentType.toString();
	}

	private org.dom4j.DocumentType _documentType;

}