package eu.jpereira.trainings.designpatterns.structural.facade;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.*;

public class DefaultBookstoreFacade implements BookstoreFacade{


     private BookDBService bookDBService;
     private CustomerDBService customerDBService;
     private CustomerNotificationService customerNotificationService;
     private OrderingService orderingService;
     private WharehouseService wharehouseService;

    @Override
    public void placeOrder(String customerId, String isbn) {
        Customer customer = customerDBService.findCustomerById(customerId);
        Book book = bookDBService.findBookByISBN(isbn);
        Order order = orderingService.createOrder( customer, book);
        DispatchReceipt dispatchReceipt = wharehouseService.dispatch(order);
        customerNotificationService.notifyClient(dispatchReceipt);
        customerNotificationService.notifyClient(order);

    }


    public void setCustomerService(CustomerDBService customerService) {
        this.customerDBService = customerService;
    }

    public void setBookService(BookDBService bookService) {
        this.bookDBService = bookService;
    }

    public void setOrderingService(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    public void setWharehouseService(WharehouseService wharehouseService) {
        this.wharehouseService = wharehouseService;
    }

    public void setCustomerNotificationService(CustomerNotificationService notificationService) {
        this.customerNotificationService = notificationService;
    }
}
