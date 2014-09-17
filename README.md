EJB-CDI-MultiDatabase
=====================
@author Wesley Egberto

@date 09/2014


Project to use EJB-CDI-Multidatabase for the users from various customers.


### Description ###

This project was made to try/test an environment where we have a multi tenant application. Each customer will have its own database and its group of users.

I created a class to simulate (Singleton with a `Map<Integer, Connection>`) a pool of Connection, when an user signs in the application, when a user of a customer sign in for the first time, the customer's Connection for its database is created and pooled linked to the customer's ID. Then, when other customer's users come already will be a Connection for him.


### Output ###

Output when a new user (Wesley) arrives:
```
21:21:01,750 INFO  [stdout] (default task-2) [JSF] IndexController created: 1133214036
21:21:01,753 INFO  [stdout] (default task-2) [EJB] ProductStatelessBean created: 233870439
21:21:01,754 INFO  [stdout] (default task-2) Setting: Product [id = 1410913261754]
21:21:01,755 INFO  [stdout] (default task-2) Login peeked from Session: null
21:21:01,756 INFO  [stdout] (default task-2) [EJB] Setting Connection: null
21:21:01,757 INFO  [stdout] (default task-2) [JSF] Setting: ProductStatelessBean [connection = null, prod = 1410913261754, hashCode = 233870439]
```

After the sign in:
```
21:21:06,823 INFO  [stdout] (default task-3) [EJB] ProductStatelessBean created: 1736736142
21:21:06,824 INFO  [stdout] (default task-3) Setting: Product [id = 1410913266824]
21:21:06,826 INFO  [stdout] (default task-3) Login peeked from Session: Login [customerId = 3245, username = Wesley]
21:21:06,827 INFO  [stdout] (default task-3) [EJB] Setting Connection: Connection [id = 3245, database = DB_CUSTOMER_3245, hashCode = 894162318]
```

Another request from user Wesley:
```
21:21:09,807 INFO  [stdout] (default task-4) [JSF] IndexController created: 109694380
21:21:09,810 INFO  [stdout] (default task-4) [EJB] ProductStatelessBean created: 736338661
21:21:09,811 INFO  [stdout] (default task-4) Setting: Product [id = 1410913269811]
21:21:09,813 INFO  [stdout] (default task-4) Login peeked from Session: Login [customerId = 3245, username = Wesley]
21:21:09,814 INFO  [stdout] (default task-4) [EJB] Setting Connection: Connection [id = 3245, database = DB_CUSTOMER_3245, hashCode = 894162318]
21:21:09,814 INFO  [stdout] (default task-4) [JSF] Setting: ProductStatelessBean [connection = Connection [id = 3245, database = DB_CUSTOMER_3245, hashCode = 894162318], prod = 1410913269811, hashCode = 736338661]
```



Output when another new user (Odair) arrives:
```
21:21:24,670 INFO  [stdout] (default task-5) [JSF] IndexController created: 861034791
21:21:24,672 INFO  [stdout] (default task-5) [EJB] ProductStatelessBean created: 1448881653
21:21:24,672 INFO  [stdout] (default task-5) Setting: Product [id = 1410913284672]
21:21:24,673 INFO  [stdout] (default task-5) Login peeked from Session: null
21:21:24,674 INFO  [stdout] (default task-5) [EJB] Setting Connection: null
21:21:24,675 INFO  [stdout] (default task-5) [JSF] Setting: ProductStatelessBean [connection = null, prod = 1410913284672, hashCode = 1448881653]
```

After the sign in:
```
21:21:35,065 INFO  [stdout] (default task-6) [EJB] ProductStatelessBean created: 2115090772
21:21:35,066 INFO  [stdout] (default task-6) Setting: Product [id = 1410913295066]
21:21:35,069 INFO  [stdout] (default task-6) Login peeked from Session: Login [customerId = 3422, username = Odair_Jose]
21:21:35,070 INFO  [stdout] (default task-6) [EJB] Setting Connection: Connection [id = 3422, database = DB_CUSTOMER_3422, hashCode = 474160115]
```

Another request from user Odair
```
21:21:39,291 INFO  [stdout] (default task-7) [JSF] IndexController created: 96758128
21:21:39,294 INFO  [stdout] (default task-7) [EJB] ProductStatelessBean created: 1036006812
21:21:39,294 INFO  [stdout] (default task-7) Setting: Product [id = 1410913299294]
21:21:39,296 INFO  [stdout] (default task-7) Login peeked from Session: Login [customerId = 3422, username = Odair_Jose]
21:21:39,297 INFO  [stdout] (default task-7) [EJB] Setting Connection: Connection [id = 3422, database = DB_CUSTOMER_3422, hashCode = 474160115]
21:21:39,297 INFO  [stdout] (default task-7) [JSF] Setting: ProductStatelessBean [connection = Connection [id = 3422, database = DB_CUSTOMER_3422, hashCode = 474160115], prod = 1410913299294, hashCode = 1036006812]
```







