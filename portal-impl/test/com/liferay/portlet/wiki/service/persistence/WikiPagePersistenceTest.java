/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.wiki.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.wiki.NoSuchPageException;
import com.liferay.portlet.wiki.model.WikiPage;

/**
 * <a href="WikiPagePersistenceTest.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class WikiPagePersistenceTest extends BasePersistenceTestCase {
	protected void setUp() throws Exception {
		super.setUp();

		_persistence = (WikiPagePersistence)PortalBeanLocatorUtil.locate(WikiPagePersistence.class.getName() +
				".impl");
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		WikiPage wikiPage = _persistence.create(pk);

		assertNotNull(wikiPage);

		assertEquals(wikiPage.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		WikiPage newWikiPage = addWikiPage();

		_persistence.remove(newWikiPage);

		WikiPage existingWikiPage = _persistence.fetchByPrimaryKey(newWikiPage.getPrimaryKey());

		assertNull(existingWikiPage);
	}

	public void testUpdateNew() throws Exception {
		addWikiPage();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		WikiPage newWikiPage = _persistence.create(pk);

		newWikiPage.setUuid(randomString());
		newWikiPage.setResourcePrimKey(nextLong());
		newWikiPage.setCompanyId(nextLong());
		newWikiPage.setUserId(nextLong());
		newWikiPage.setUserName(randomString());
		newWikiPage.setCreateDate(nextDate());
		newWikiPage.setModifiedDate(nextDate());
		newWikiPage.setNodeId(nextLong());
		newWikiPage.setTitle(randomString());
		newWikiPage.setVersion(nextDouble());
		newWikiPage.setMinorEdit(randomBoolean());
		newWikiPage.setContent(randomString());
		newWikiPage.setSummary(randomString());
		newWikiPage.setFormat(randomString());
		newWikiPage.setHead(randomBoolean());
		newWikiPage.setParentTitle(randomString());
		newWikiPage.setRedirectTitle(randomString());

		_persistence.update(newWikiPage, false);

		WikiPage existingWikiPage = _persistence.findByPrimaryKey(newWikiPage.getPrimaryKey());

		assertEquals(existingWikiPage.getUuid(), newWikiPage.getUuid());
		assertEquals(existingWikiPage.getPageId(), newWikiPage.getPageId());
		assertEquals(existingWikiPage.getResourcePrimKey(),
			newWikiPage.getResourcePrimKey());
		assertEquals(existingWikiPage.getCompanyId(), newWikiPage.getCompanyId());
		assertEquals(existingWikiPage.getUserId(), newWikiPage.getUserId());
		assertEquals(existingWikiPage.getUserName(), newWikiPage.getUserName());
		assertEquals(Time.getShortTimestamp(existingWikiPage.getCreateDate()),
			Time.getShortTimestamp(newWikiPage.getCreateDate()));
		assertEquals(Time.getShortTimestamp(existingWikiPage.getModifiedDate()),
			Time.getShortTimestamp(newWikiPage.getModifiedDate()));
		assertEquals(existingWikiPage.getNodeId(), newWikiPage.getNodeId());
		assertEquals(existingWikiPage.getTitle(), newWikiPage.getTitle());
		assertEquals(existingWikiPage.getVersion(), newWikiPage.getVersion());
		assertEquals(existingWikiPage.getMinorEdit(), newWikiPage.getMinorEdit());
		assertEquals(existingWikiPage.getContent(), newWikiPage.getContent());
		assertEquals(existingWikiPage.getSummary(), newWikiPage.getSummary());
		assertEquals(existingWikiPage.getFormat(), newWikiPage.getFormat());
		assertEquals(existingWikiPage.getHead(), newWikiPage.getHead());
		assertEquals(existingWikiPage.getParentTitle(),
			newWikiPage.getParentTitle());
		assertEquals(existingWikiPage.getRedirectTitle(),
			newWikiPage.getRedirectTitle());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		WikiPage newWikiPage = addWikiPage();

		WikiPage existingWikiPage = _persistence.findByPrimaryKey(newWikiPage.getPrimaryKey());

		assertEquals(existingWikiPage, newWikiPage);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchPageException");
		}
		catch (NoSuchPageException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		WikiPage newWikiPage = addWikiPage();

		WikiPage existingWikiPage = _persistence.fetchByPrimaryKey(newWikiPage.getPrimaryKey());

		assertEquals(existingWikiPage, newWikiPage);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		WikiPage missingWikiPage = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingWikiPage);
	}

	protected WikiPage addWikiPage() throws Exception {
		long pk = nextLong();

		WikiPage wikiPage = _persistence.create(pk);

		wikiPage.setUuid(randomString());
		wikiPage.setResourcePrimKey(nextLong());
		wikiPage.setCompanyId(nextLong());
		wikiPage.setUserId(nextLong());
		wikiPage.setUserName(randomString());
		wikiPage.setCreateDate(nextDate());
		wikiPage.setModifiedDate(nextDate());
		wikiPage.setNodeId(nextLong());
		wikiPage.setTitle(randomString());
		wikiPage.setVersion(nextDouble());
		wikiPage.setMinorEdit(randomBoolean());
		wikiPage.setContent(randomString());
		wikiPage.setSummary(randomString());
		wikiPage.setFormat(randomString());
		wikiPage.setHead(randomBoolean());
		wikiPage.setParentTitle(randomString());
		wikiPage.setRedirectTitle(randomString());

		_persistence.update(wikiPage, false);

		return wikiPage;
	}

	private WikiPagePersistence _persistence;
}