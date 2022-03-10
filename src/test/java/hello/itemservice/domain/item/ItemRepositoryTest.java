package hello.itemservice.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

	private ItemRepository itemRepository = new ItemRepository();

	@AfterEach
	public void afterEach() {
		itemRepository.clearStore();
	}

	@Test
	void save() {
		// given
		Item item = new Item("itemA", 10000, 10);

		// when
		Item saveItem = itemRepository.save(item);

		// then
		Item findItem = itemRepository.findById(item.getId());

		assertThat(saveItem).isEqualTo(findItem);
	}

	@Test
	void findAll() {
		// given
		Item itemA = new Item("itemA", 10000, 10);
		Item itemB = new Item("itemB", 10000, 10);
		
		itemRepository.save(itemA);
		itemRepository.save(itemB);
		
		//when
		List<Item> result = itemRepository.findAll();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result).contains(itemA, itemB);
	}
	
	@Test
	void update() {
		//given
		Item itemA = new Item("itemA", 10000, 10);
		Item saveItem = itemRepository.save(itemA);
		Long itemId = saveItem.getId();
		
		//when 
		Item upateItem = new Item("item2", 20000, 3);
		itemRepository.update(itemId, upateItem);
		
		//then
		Item findItem = itemRepository.findById(itemId);
		assertThat(findItem.getItemName()).isEqualTo(upateItem.getItemName());
		assertThat(findItem.getItemName()).isEqualTo(upateItem.getItemName());
		assertThat(findItem.getItemName()).isEqualTo(upateItem.getItemName());
	}

}
