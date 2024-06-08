package hust.soict.dsai.aims.media;

import java.util.Scanner;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.store.Store;

public class Aims {

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
	
	public static void updateStoreMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media to store");
		System.out.println("2. Remove media from cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	public static void main(String[] args) throws PlayerException {
		Scanner sc = new Scanner(System.in);
		
		Store store = new Store();
		store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animated", 15.5f));
		store.addMedia(new DigitalVideoDisc(2, "Aladin", "Animated", 35.2f));
		store.addMedia(new DigitalVideoDisc(3, "Star Wars", "Animated", 55.6f));
		
		Cart cart = new Cart();
		int opt = -1; int storeOpt = -1; int mediaOpt = -1; int cartOpt = -1; 
		int updateOpt = -1; int filterOpt = -1; int sortOpt = -1;
	    do {
            showMenu();
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    store.checkStore();
                    do {
                        storeMenu();
                        storeOpt = sc.nextInt();
                        sc.nextLine();
                        switch (storeOpt) {
                            case 1: //1. See a media’s details
                                System.out.println("Enter the media's title: ");
                                String title = sc.nextLine();
                                Media media = store.searchByTitle(title);
                                if (media != null) {
                                    media.toString();
                                    do {
                                        mediaDetailsMenu();
                                        mediaOpt = sc.nextInt();
                                        sc.nextLine();
                                        switch (mediaOpt) {
                                            case 1: // Add to cart
                                            	cart.addMedia(media);
                                            	System.out.println("The media has been added!");
                                            	System.out.println("Number of items in your cart: " + cart.getNumber());
                                            	break;
                                            	
                                            case 2: // Play
                                                if (media instanceof DigitalVideoDisc ) {
                                                    ((DigitalVideoDisc) media).play();
                                                } else if (media instanceof CompactDisc) {
                                                	((CompactDisc) media).play();
                                                } else {
                                                    System.out.println("This media cannot be played!");
                                                }
                                                break;
                                                
                                            case 0: // Back
                                            	break;
                                            	
                                            default: 
                                            	System.out.println("Invalid option! Please choose a number: 0-1-2"); 
                                            	break;
                                        }
                                    } while (mediaOpt != 0);
                                } else {
                                    System.out.println("The media is not in the store!");
                                }
                                break;
                                
                            case 2: // Add media to cart
                                System.out.print("Enter the media's title: ");
                                title = sc.nextLine();
                                media = store.searchByTitle(title);
                                if (media != null) {
                                    cart.addMedia(media);
                                    System.out.println("The media has been added");
                                    System.out.println("Number of items in your cart: " + cart.getNumber());
                                } else {
                                    System.out.println("The media is not in the store!");
                                }
                                break;
                                
                            case 3: // Play a media
                                System.out.print("Enter title of media: ");
                                title = sc.nextLine();
                                media = store.searchByTitle(title);
                                if (media != null) {
                                	if (media instanceof DigitalVideoDisc ) {
                                        ((DigitalVideoDisc) media).play();
                                    } else if (media instanceof CompactDisc) {
                                    	((CompactDisc) media).play();
                                    } else {
                                        System.out.println("The media cannot be played!");
                                    }
                                } else {
                                    System.out.println("The media is not in the store!");
                                }
                                break;
                                
                            case 4: // See current cart
                                cart.print();
                                break;
                                
                            case 0: // Back
                            	break;
                            	
                            default: 
                            	System.out.println("Invalid option! Please choose a number: 0-1-2-3-4");
                            	break;
                        }
                    } while (storeOpt != 0);
                    break;

                case 2: // Update store
                    do{
                    	updateStoreMenu();
                        updateOpt = sc.nextInt();
                        sc.nextLine();
                        switch (updateOpt) {
                            case 1: // Add media to store
                            	Media media;
                                System.out.println("Enter the media's details: ");
                                System.out.println("- Type: DVD or CompactDisc?");
                                String type = sc.nextLine();
                                System.out.println("- Title: ");
                                String title = sc.nextLine();
                                System.out.println("- Category: ");
                                String category = sc.nextLine();
                                System.out.println("- Cost: ");
                                float cost = sc.nextFloat();
                                int id = store.getNumber();
                                if (type.equals("DVD")) {
                                	media = new DigitalVideoDisc(id, title, category, cost);
                                } else {
                                	media = new CompactDisc(id, title, category, cost);
                                }
                                store.addMedia(media);
                                break;
                                
                            case 2: // Remove media from store
                                System.out.println("Enter the media's title: ");
                                title = sc.nextLine();
                                media = store.searchByTitle(title);
                                store.removeMedia(media);
                                break;
                                
                            case 0: // Back
                            	break;
                            	
                            default: 
                            	System.out.println("Invalid option! Please choose a number: 0-1-2");
                            	break;
                        }
                    } while (updateOpt != 0);
                    break;
                    
                case 3: // See current cart
                    cart.print();
                    do {
                        cartMenu();
                        cartOpt = sc.nextInt();
                        sc.nextLine();
                        switch (cartOpt) {
                            case 1: // 1. Filter medias in cart
                                Media media;
                            	System.out.println("1. Filter by id\n2. Filter by title\nPlease choose a number: 1-2");
                                filterOpt = sc.nextInt();
                                sc.nextLine();
                                if (filterOpt == 1) {
                                	System.out.println("Enter id: ");
                                    int filterId = sc.nextInt();
                                    media = cart.searchByID(filterId);
                                } else {
                                	System.out.println("Enter title: ");
                                    String filterTitle = sc.nextLine();
                                    media = cart.searchByTitle(filterTitle);
                                }
                                if (media != null) {
                                    System.out.println("Media found: ");
                                    System.out.println(media.toString()); 
                                } else {
                                    System.out.println("No media found!");
                                }
                                break;
                                
                            case 2: // 2. Sort medias in cart
                                System.out.println("1. Sort by title\n2. Sort by cost\nPlease choose a number: 1-2");
                                sortOpt = sc.nextInt();
                                sc.nextLine();
                                if (sortOpt == 1) {
                                    cart.sortByTitle();
                                } else {
                                    cart.sortByCost();
                                }
                                System.out.println("After sorting: ");
                                cart.print();
                                break;
                                
                            case 3: // Remove media from cart
                                System.out.print("Enter the media's title: ");
                                String title = sc.nextLine();
                                media = cart.searchByTitle(title);
                                if(media != null){
                                    cart.removeMedia(media);
                                    System.out.println("The media has been removed from your cart!");
                                    cart.print();
                                } else {
                                    System.out.println("The media is not in the cart!");
                                }
                                break;
                                
                            case 4: // Play a media
                                System.out.print("Enter the media's title: ");
                                title = sc.nextLine();
                                media = cart.searchByTitle(title);
                                if (media instanceof DigitalVideoDisc ) {
                                    ((DigitalVideoDisc) media).play();
                                } else if (media instanceof CompactDisc) {
                                	((CompactDisc) media).play();
                                } else {
                                    System.out.println("The media is not in the cart!");
                                }
                                break;
                                
                            case 5: // Place order
                                System.out.println("An order is created!");
                                cart = new Cart(); 
                                break;
                            case 0: // Back 
                            	break;
                            default: 
                            	System.out.println("Invalid option! Please choose a number: 0-1-2-3-4-5"); 
                            	break;
                        }
                    } while (cartOpt != 0);
                    break;
                    
                case 0: // Back
                	break;
                default: 
                	System.out.println("Invalid option! Please choose a number: 0-1-2");
            }
        } while (opt != 0);
	}
}
