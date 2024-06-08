package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private Cart cart;

	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel(); 
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		System.out.println();
		DigitalVideoDisc dvd = new DigitalVideoDisc("Bleach");
		Book book = new Book("Nhập môn VLĐC cho trẻ 2 tuổi", "Quà tặng cuộc sống", 2.69f);
		
		List<Track> test = new ArrayList<Track>();
		Track track1 = new Track("Monster", 3);
		Track track2 = new Track("Idol", 4);
		Track track3 = new Track("Heart Beat", 6);
		test.add(track1);
		test.add(track2);
		test.add(track3);
		CompactDisc cd = new CompactDisc("Baka mitai", "?", "Yakuza", 3, 5, "Yakuza", test);
		
		
		Cart cart = new Cart();
		cart.addMedia(dvd);
		cart.addMedia(book);
		cart.addMedia(cd);
		
		new CartScreen(cart);
	}
}
