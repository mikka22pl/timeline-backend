package org.ulv.timeline.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ulv.timeline.dao.RssEntryDao;
import org.ulv.timeline.dao.RssFeedDao;
import org.ulv.timeline.dao.TagDao;
import org.ulv.timeline.model.AssignedItem;
import org.ulv.timeline.model.Tag;
import org.ulv.timeline.model.builders.CategoryBuilder;
import org.ulv.timeline.model.builders.RssEntryBuilder;
import org.ulv.timeline.model.builders.TagBuilder;
import org.ulv.timeline.model.rss.RssEntry;

@RunWith(MockitoJUnitRunner.class)
public class RssFeedServiceImplTest {

	@Mock
	private RssFeedDao feedDao;
	@Mock
	private RssEntryDao entryDao;
	@Mock
	private TagDao tagDao;
	@Mock
	private CategoryService categoryService;
	@Mock
	private TagService tagService;
	@Mock
	private TimelineService timelineService;
	
	@InjectMocks
	private RssFeedService service = new RssFeedServiceImpl();
	
	@Test
	public void should_save_all_new_tags_and_remove_not_existing() {
		// given
		RssEntry entry = createEntry();
		List<Tag> dbTags = Arrays.asList(
				new TagBuilder().withId(1).build(),
				new TagBuilder().withId(3).build(),
				new TagBuilder().withId(5).build(),
				new TagBuilder().withId(6).build());
		
		when(tagDao.getEntryTags(entry.getId())).thenReturn(dbTags);
		doNothing().when(entryDao).removeTags(any(AssignedItem.class));
		doNothing().when(entryDao).assignTags(entry);
		
		// when
		Map<String, List<Integer>> map = service.assignTags(entry);
		
		// then
		assertThat(map).isNotNull();
		assertThat(map.size()).isEqualTo(2);
		assertThat(map.get("SAVED")).isNotNull();
		assertThat(map.get("SAVED").size()).isEqualTo(2);
		assertThat(map.get("SAVED").get(0)).isNotNull();
		assertThat(map.get("SAVED").get(0)).isEqualTo(2);
		assertThat(map.get("SAVED").get(1)).isNotNull();
		assertThat(map.get("SAVED").get(1)).isEqualTo(4);
		
		assertThat(map.get("REMOVED")).isNotNull();
		assertThat(map.get("REMOVED").size()).isEqualTo(2);
		assertThat(map.get("REMOVED").get(0)).isNotNull();
		assertThat(map.get("REMOVED").get(0)).isEqualTo(5);
		assertThat(map.get("REMOVED").get(1)).isNotNull();
		assertThat(map.get("REMOVED").get(1)).isEqualTo(6);
		
	}
	
	@Test
	public void should_do_not_save_and_remove() {
		// given
		RssEntry entry = createEntry();
		List<Tag> dbTags = Arrays.asList(
				new TagBuilder().withId(1).build(),
				new TagBuilder().withId(2).build(),
				new TagBuilder().withId(3).build(),
				new TagBuilder().withId(4).build());
		
		when(tagDao.getEntryTags(entry.getId())).thenReturn(dbTags);
		doNothing().when(entryDao).removeTags(any(AssignedItem.class));
		doNothing().when(entryDao).assignTags(entry);
		
		// when
		Map<String, List<Integer>> map = service.assignTags(entry);
		
		// then
		assertThat(map).isNotNull();
		assertThat(map.size()).isEqualTo(2);
		assertThat(map.get("SAVED")).isNotNull();
		assertThat(map.get("SAVED").size()).isEqualTo(0);
		
		assertThat(map.get("REMOVED")).isNotNull();
		assertThat(map.get("REMOVED").size()).isEqualTo(0);
	}
	
	@Test
	public void should_only_remove_one() {
		// given
		RssEntry entry = createEntry();
		List<Tag> dbTags = Arrays.asList(
				new TagBuilder().withId(1).build(),
				new TagBuilder().withId(2).build(),
				new TagBuilder().withId(3).build(),
				new TagBuilder().withId(4).build(),
				new TagBuilder().withId(5).build());
		
		when(tagDao.getEntryTags(entry.getId())).thenReturn(dbTags);
		doNothing().when(entryDao).removeTags(any(AssignedItem.class));
		doNothing().when(entryDao).assignTags(entry);
		
		// when
		Map<String, List<Integer>> map = service.assignTags(entry);
		
		// then
		assertThat(map).isNotNull();
		assertThat(map.size()).isEqualTo(2);
		assertThat(map.get("SAVED")).isNotNull();
		assertThat(map.get("SAVED").size()).isEqualTo(0);
		
		assertThat(map.get("REMOVED")).isNotNull();
		assertThat(map.get("REMOVED").size()).isEqualTo(1);
		assertThat(map.get("REMOVED").get(0)).isNotNull();
		assertThat(map.get("REMOVED").get(0)).isEqualTo(5);
	}
	
	@Test
	public void should_only_save_one() {
		// given
		RssEntry entry = createEntry();
		List<Tag> dbTags = Arrays.asList(
				new TagBuilder().withId(1).build(),
				new TagBuilder().withId(2).build(),
				new TagBuilder().withId(3).build());
		
		when(tagDao.getEntryTags(entry.getId())).thenReturn(dbTags);
		doNothing().when(entryDao).removeTags(any(AssignedItem.class));
		doNothing().when(entryDao).assignTags(entry);
		
		// when
		Map<String, List<Integer>> map = service.assignTags(entry);
		
		// then
		assertThat(map).isNotNull();
		assertThat(map.size()).isEqualTo(2);
		assertThat(map.get("SAVED")).isNotNull();
		assertThat(map.get("SAVED").size()).isEqualTo(1);
		assertThat(map.get("SAVED").get(0)).isNotNull();
		assertThat(map.get("SAVED").get(0)).isEqualTo(4);
		
		assertThat(map.get("REMOVED")).isNotNull();
		assertThat(map.get("REMOVED").size()).isEqualTo(0);
	}
	
	@Test
	public void should_save_entry() throws Exception {
		// given
		RssEntry entry = createEntry();
		List<Integer> tagsIds = Arrays.asList(1, 2, 3);
		when(categoryService.saveOrFind(entry.getCategory()))
				.thenReturn(entry.getCategory());
		
		when(tagService.saveTags(entry.getTags(), 
				entry.getRssFeed().getDistributor().getLanguage().getId()))
				.thenReturn(tagsIds);
		doNothing().when(timelineService).assignArticle(any(), any());
		doNothing().when(entryDao).updateEntry(entry);
		
		// when
		RssEntry savedEntry = service.saveEntry(entry);
		
		// then
		assertThat(savedEntry).isNotNull();
	}
	
	private RssEntry createEntry() {
		return new RssEntryBuilder()
				.withId(1)
				.withCategory(new CategoryBuilder().withId(1).build())
				.withTag(new TagBuilder().withId(1).withName("a").build())
				.withTag(new TagBuilder().withId(2).withName("b").build())
				.withTag(new TagBuilder().withId(3).withName("c").build())
				.withTag(new TagBuilder().withId(4).withName("d").build())
				.build();
	}
}
