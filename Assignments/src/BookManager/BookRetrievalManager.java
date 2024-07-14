package BookManager;

public class BookRetrievalManager {
	
	public static void main(String[] args) {
		System.out.printf("%s%n", "Books By Author");
		connectToDatabase dbManager = new connectToDatabase();
		dbManager.getAllBooks();
		System.out.printf("%n%n%n%s ", "Books By Author");
		dbManager.getBooksByAuthor("Harvey Deitel");
		System.out.printf("%n%n%n%s ", "Books Publisher After Year");
		dbManager.getBooksPublisherAfterYear(2020);
	}
}
