package it.sopra.stage.fullmoda;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import it.sopra.stage.fullmoda.dao.AddressRepository;
import it.sopra.stage.fullmoda.dao.BaseProductRepository;
import it.sopra.stage.fullmoda.dao.CartEntryRepository;
import it.sopra.stage.fullmoda.dao.CartRepository;
import it.sopra.stage.fullmoda.dao.ColorRepository;
import it.sopra.stage.fullmoda.dao.ColorVariantProductRepository;
import it.sopra.stage.fullmoda.dao.CountryRepository;
import it.sopra.stage.fullmoda.dao.CurrencyRepository;
import it.sopra.stage.fullmoda.dao.OrderRepository;
import it.sopra.stage.fullmoda.dao.PaymentMethodRepository;
import it.sopra.stage.fullmoda.dao.PriceRepository;
import it.sopra.stage.fullmoda.dao.SizeVariantProductRepository;
import it.sopra.stage.fullmoda.dao.StockRepository;
import it.sopra.stage.fullmoda.dao.UserRepository;
import it.sopra.stage.fullmoda.dao.WarehouseRepository;
import it.sopra.stage.fullmoda.dao.WebsiteRepository;
import it.sopra.stage.fullmoda.model.Address;
import it.sopra.stage.fullmoda.model.BaseProduct;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;
import it.sopra.stage.fullmoda.model.Color;
import it.sopra.stage.fullmoda.model.ColorVariantProduct;
import it.sopra.stage.fullmoda.model.Country;
import it.sopra.stage.fullmoda.model.Currency;
import it.sopra.stage.fullmoda.model.Order;
import it.sopra.stage.fullmoda.model.PaymentMethod;
import it.sopra.stage.fullmoda.model.Price;
import it.sopra.stage.fullmoda.model.PricePK;
import it.sopra.stage.fullmoda.model.Size;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;
import it.sopra.stage.fullmoda.model.Stock;
import it.sopra.stage.fullmoda.model.StockPK;
import it.sopra.stage.fullmoda.model.User;
import it.sopra.stage.fullmoda.model.Warehouse;
import it.sopra.stage.fullmoda.model.Website;
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class FullmodaApplicationTests {

	@Autowired
	ApplicationContext context;
	
	private static final Logger logger = Logger.getLogger(FullmodaApplicationTests.class);
	
	@Ignore
	public void saveStock() {
		StockRepository stockRepos = context.getBean(StockRepository.class);
		WarehouseRepository warehouseRepos = context.getBean(WarehouseRepository.class);
		SizeVariantProductRepository productRepository= context.getBean(SizeVariantProductRepository.class);
		SizeVariantProduct product = productRepository.findOne("0007811");
		Warehouse warehouse = warehouseRepos.findOne("warehouse_it");
		Stock stock = new Stock(new StockPK (product, warehouse), product, warehouse, 100, 0);
		stockRepos.save(stock);
	}
	@Test
	public void findProductPrice() {
		PriceRepository priceRepository= context.getBean(PriceRepository.class);
		BaseProductRepository productRepository= context.getBean(BaseProductRepository.class);
		BaseProduct baseProduct = productRepository.findOne("00087");
		CurrencyRepository currencyRepos = context.getBean(CurrencyRepository.class);
		Currency curr_eur = currencyRepos.findOne("EUR");
		Price price = priceRepository.findByBaseProductCodeAndCurrencyCode(baseProduct.getCode(), curr_eur.getCode());
		System.out.println("PRICE____"+price);
	}
	@Ignore
	public void saveProductPrice() {
		PriceRepository priceRepository= context.getBean(PriceRepository.class);
		BaseProductRepository productRepository= context.getBean(BaseProductRepository.class);
		BaseProduct baseProduct = productRepository.findOne("00087");
		CurrencyRepository currencyRepos = context.getBean(CurrencyRepository.class);
		Currency curr_eur = currencyRepos.findOne("EUR");
		Currency curr_usd = currencyRepos.findOne("USD");
		Price price_eur = new Price(new PricePK(baseProduct, curr_eur),new BigDecimal ("123.34"), baseProduct, curr_eur);
		Price price_usd = new Price(new PricePK(baseProduct, curr_usd),new BigDecimal ("100.34"), baseProduct, curr_usd);
		priceRepository.save(price_eur);
		priceRepository.save(price_usd);
	}
	@Ignore
	public void saveOrder() {
		OrderRepository orderRepos = context.getBean(OrderRepository.class);
		CartRepository cartRepos =  context.getBean(CartRepository.class);
		PaymentMethodRepository paymentRepos =  context.getBean(PaymentMethodRepository.class);
		Cart cart = cartRepos.findOne(6L);
		PaymentMethod paymentMethod = paymentRepos.findOne("creditcard");
		Address userAddress = cart.getUser().getAddress();
		Order order = new Order(cart, new BigDecimal ("10000"), new Date(),userAddress, userAddress, paymentMethod);
		orderRepos.save(order);
	}
	@Ignore
	public void saveCart() {
		CartRepository cartRepos =  context.getBean(CartRepository.class);
		CartEntryRepository CartEntryRepos =  context.getBean(CartEntryRepository.class);
		SizeVariantProductRepository sizeVariantRepos = context.getBean(SizeVariantProductRepository.class);
		WebsiteRepository websiteRepos = context.getBean(WebsiteRepository.class);
		Website website = websiteRepos.findOne("fullmoda_it");
		
		UserRepository userRepos = context.getBean(UserRepository.class);
		User user = userRepos.findByEmail("giggetto@yopmail.com");
		
		Cart cart = new Cart(user, website);
		SizeVariantProduct sizeVariantProduct =	sizeVariantRepos.findOne("0007811");
		SizeVariantProduct sizeVariantProduct2 = sizeVariantRepos.findOne("0007812");
		CartEntry entry1 = new CartEntry(sizeVariantProduct, 2);
		CartEntry entry2 = new CartEntry(sizeVariantProduct2, 1);
		LinkedList<CartEntry> entries = new LinkedList<>();
		entries.add(entry1);
		entries.add(entry2);
		cart.addCartEntries(entries);
		cartRepos.save(cart);
		
		System.out.println(cart.getId());
		

	}
	
	@Ignore
	public void saveUser() {
		UserRepository userRepos = context.getBean(UserRepository.class);
		Country country = new Country("FR", "Francia");
		CountryRepository countryRepos = context.getBean(CountryRepository.class);
		countryRepos.save(country);
		Address address = new Address("", "via filippo lippi 1", "", "20180", "roma", country);
		AddressRepository addressRepos = context.getBean(AddressRepository.class);
		addressRepos.save(address);
		User user = new User("gigetto", "luigi", "di maio", "CUSTOMER", "giggetto@yopmail.com", "04908304593", null, null, true, null, address);
		userRepos.save(user);
	}
	
	@Ignore
	public void saveAddress() {
		
		CountryRepository countryRepos = context.getBean(CountryRepository.class);
		AddressRepository addressRepos = context.getBean(AddressRepository.class);
		
		Country country = countryRepos.findOne("IT");
		Address address = new Address("", "via filippo lippi 1", "", "20180", "roma", country);
		Country country2 = new Country("FR", "Francia");
		countryRepos.save(country2);
		Address address2 = new Address("", "via filippo lippi 1", "", "20180", "roma", country2);
		addressRepos.save(address);
		addressRepos.save(address2);
		
	}
	
	@Ignore
	public void saveProduct() {
		Calendar calendar_start = Calendar.getInstance();
		calendar_start.set(2017, 11, 01, 00, 01);
		Calendar calendar_end = Calendar.getInstance();
		calendar_end.set(2999, 11, 31, 23, 59);
		BaseProductRepository productRepository= context.getBean(BaseProductRepository.class);
		ColorRepository colorRepository= context.getBean(ColorRepository.class);
		ColorVariantProductRepository pcolVarRepo= context.getBean(ColorVariantProductRepository.class);
		BaseProduct baseProduct = new BaseProduct("00087", "prodotto base 00087", "bel prodotto base 00087", calendar_start.getTime(), calendar_end.getTime());
		System.out.println(baseProduct);
		Color color1 = colorRepository.findByCode("aqua");
//		Color color2 = colorRepository.findByCode("black");
//		System.out.println("\n*****"+color2+"\n");
		ColorVariantProduct colorProduct1= new ColorVariantProduct("000781", color1, baseProduct);
		Color color = new Color("adasd", "fdkjs");
		ColorVariantProduct colorProduct2 = new ColorVariantProduct("000782", color, baseProduct);
		colorProduct2.setColor(color);
		
		SizeVariantProduct sizeV1 = new SizeVariantProduct("0007811", new Size("s_36"), colorProduct1);
		SizeVariantProduct sizeV2 = new SizeVariantProduct("0007812", new Size("s_37"), colorProduct1);
		
		SizeVariantProduct sizeV3 = new SizeVariantProduct("0007821", new Size("s_38"), colorProduct2);
		SizeVariantProduct sizeV4 = new SizeVariantProduct("0007822", new Size("s_39"), colorProduct2);
		
		colorProduct1.addSizeVariantProduct(sizeV1);
		colorProduct1.addSizeVariantProduct(sizeV2);
		
		colorProduct2.addSizeVariantProduct(sizeV3);
		colorProduct2.addSizeVariantProduct(sizeV4);
		
//		System.out.println("\n*****"+colorProduct2+"\n");
		List<ColorVariantProduct> variants = Lists.newArrayList(colorProduct2 ,colorProduct1);
		baseProduct.addColorVariants(variants);
		
		
		
		
		
		productRepository.save(baseProduct);
//		pcolVarRepo.save(colorProduct2);
		
//		BaseProduct baseProduct_found = productRepository.findOne("00077");
//		BaseProduct p2 = productRepository.findByCode("2");
//		System.out.println(baseProduct_found);

//		List<BaseProduct> prodotti = productRepository.findByOnlineDateAfterAndOfflineDateBefore(calendar_start.getTime(), calendar_end.getTime());
//		
//		for(BaseProduct p : prodotti) {
//			System.out.println(p);
//		}
		
		
	}

}
