package com.uitgis.ubps.gdssquery;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.uitgis.ubps.gdssquery.domain.Author;
import com.uitgis.ubps.gdssquery.domain.Doc;
import com.uitgis.ubps.gdssquery.domain.Publisher;
import com.uitgis.ubps.gdssquery.searchrepository.DocsearchRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QueryApplication.class)
public class DocsearchServiceTest {

	@Autowired
	private DocsearchRepository docsearchRepository;

	@Autowired
	private ElasticsearchTemplate esTemplate;

	@Before
	public void before() {
		esTemplate.deleteIndex(Doc.class);
		esTemplate.createIndex(Doc.class);
		esTemplate.putMapping(Doc.class);
		esTemplate.refresh(Doc.class);
	}

	@Test
	public void testSave() {

    
		
		Author author = new Author("Albert Einstein","Princeton","009000900", "albert@gmail.com");
	    
		Publisher publisher = new Publisher("VIUP", "10, Hoa Lu, Ha Noi", "0987777898");

		Doc doc = new Doc(1L, "Greencity Indicators", "pdf", "Green City", "English", "12-MAR-2016", "first step to Going green", "for all od us", author, publisher);
		
		Doc testDoc = docsearchRepository.save(doc);

		assertNotNull(testDoc.getId());
		assertEquals(testDoc.getTitle(), doc.getTitle());
		assertEquals(testDoc.getAuthor(), doc.getAuthor());
		assertEquals(testDoc.getReleaseDate(), doc.getReleaseDate());
	}

	@Test
	public void testFindOne() {

		Author author = new Author("Albert Einstein","Princeton","009000900", "albert@gmail.com");
	    
		Publisher publisher = new Publisher("VIUP", "10, Hoa Lu, Ha Noi", "0987777898");

		Doc doc = new Doc(1L, "Greencity Indicators", "pdf", "Green City", "English", "12-MAR-2016", "first step to Going green", "for all od us", author, publisher);
		
		Doc testDoc = docsearchRepository.save(doc);


		testDoc = docsearchRepository.findOne(doc.getId());

		assertNotNull(testDoc.getId());
		assertEquals(testDoc.getTitle(), doc.getTitle());
		assertEquals(testDoc.getAuthor(), doc.getAuthor());
		assertEquals(testDoc.getReleaseDate(), doc.getReleaseDate());

	}

	@Test
	public void testFindByTitle() {

		Author author = new Author("Albert Einstein","Princeton","009000900", "albert@gmail.com");
	    
		Publisher publisher = new Publisher("VIUP", "10, Hoa Lu, Ha Noi", "0987777898");

		Doc doc = new Doc(1L, "Greencity Indicators", "pdf", "Green City", "English", "12-MAR-2016", "first step to Going green", "for all od us", author, publisher);
		
		docsearchRepository.save(doc);

		List<Doc> byTitle = docsearchRepository.findByTitle(doc.getTitle());
		
		assertThat(byTitle.size(), is(1));
	}

    @Test
    public void testFindByAuthor() {

        List<Doc> upList = new ArrayList<>();

        upList.add(new Doc(1L,"Greencity Indicators1", "pdf", "Green City", "English", "12-MAR-2016", "first step to Going green", "for all od us",  new Author("Albert Einstein","Princeton","009000900", "albert@gmail.com"), new Publisher("VIUP-1", "Ha Noi", "0900000000")));
        upList.add(new Doc(2L,"Greencity Indicators2", "doc", "Polulation", "English", "12-MAR-2016", "first step to Going green", "for all od us",  new Author("Tomy Hank","Princeton","009000900", "tml@gmail.com"), new Publisher("VIUP-2", "Ha Nam Ninh", "090000111")));
        upList.add(new Doc(3L,"Greencity Indicators3", "xls", "Green City", "English", "12-MAR-2016", "first step to Going green", "for all od us",  new Author("Albert Einstein","Princeton","009000900", "albert@gmail.com"), new Publisher("VIUP-1", "Ha Noi", "0900000000")));
        upList.add(new Doc(4L,"Greencity Indicators4", "docx", "Green City", "English", "12-MAR-2016", "first step to Going green", "for all od us", new Author("Bob kery","Princeton","009000900", "bbj@gmail.com"), new Publisher("VIU-2P", "Ha Nnm Ninh", "090000111")));
        upList.add(new Doc(5L,"Greencity Indicators5", "jpg", "Green City", "English", "12-MAR-2016", "first step to Going green", "for all od us",  new Author("Albert Einstein","Princeton","009000900", "albert@gmail.com"), new Publisher("BXD", "HCMC", "0987777898")));

        for (Doc upload : upList) {
        	docsearchRepository.save(upload);
        }

        Page<Doc> byAuthor = docsearchRepository.findByCategory("Green City", new PageRequest(0, 10));
        assertThat(byAuthor.getTotalElements(), is(4L));

        Page<Doc> byAuthor2 = docsearchRepository.findByCategory("Polulation", new PageRequest(0, 10));
        assertThat(byAuthor2.getTotalElements(), is(1L));

    }
	
    @Test
    public void testDelete() {

    	Doc doc = new Doc(1L,"Greencity Indicators1", "pdf", "Green City", "English", "12-MAR-2016", "first step to Going green", "for all od us",  new Author("Albert Einstein","Princeton","009000900", "albert@gmail.com"), new Publisher("VIUP-1", "Ha Noi", "0900000000"));
    	docsearchRepository.save(doc);
    	docsearchRepository.delete(doc);
    	Doc testDoc = docsearchRepository.findOne(doc.getId());
        assertNull(testDoc);
    }
    
}
