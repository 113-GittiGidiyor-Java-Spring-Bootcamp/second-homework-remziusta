# İkinci ödev teslim tarihi : 22 Ağustos - 23:00
### Not : ARAŞTIRMA KONUSU kısmı tamamıyla sizleri geliştirmek amaçlı , eklenmiştir , o madde için herhangi bir kod vs örneğine ihtiyaç yoktur.

![homework](https://user-images.githubusercontent.com/45206582/129493929-01f3b3a7-793f-4057-959a-ac5fb05ad8a8.png)

# Instructor Path
| Request 	|                  Route                  	|                                             Body                                            	|                        Description                        	|
|:-------:	|:---------------------------------------:	|:-------------------------------------------------------------------------------------------:	|:---------------------------------------------------------:	|
|   GET   	|               /instructor               	|                                            EMPTY                                            	|                    List all instructor                    	|
|   GET   	|            /instructor/{:id}            	|                                            EMPTY                                            	|                      Get a instructor                     	|
|   POST  	|               /instructor               	|      { name:":name", address:"address", phoneNumber:":phoneNumber", salary:":salary" }      	|                      Add a instructor                     	|
|   POST  	| /instructor/{:instructorId}/{:courseId} 	|                                            EMPTY                                            	| Add a course in instructor and add a instructor in course 	|
|   PUT   	|               /instructor               	| { id:":id", name:":name", address:"address", phoneNumber:":phoneNumber", salary:":salary" } 	|                    Update a instructor                    	|
|  DELETE 	|            /instructor/{:id}            	|                                            EMPTY                                            	|                    Delete a instructor                    	|

# Course Path
| Request 	|     Route     	|                                 Body                                 	|   Description   	|
|:-------:	|:-------------:	|:--------------------------------------------------------------------:	|:---------------:	|
|   GET   	|    /course    	|                                 EMPTY                                	| List all course 	|
|   GET   	| /course/{:id} 	|                                 EMPTY                                	|   Get a course  	|
|   POST  	|    /course    	|      { courseName:":courseName", courseCredit:":courseCredit" }      	|   Add a course  	|
|   PUT   	|    /course    	| { id:":id" ,courseName:":courseName", courseCredit:":courseCredit" } 	| Update a course 	|
|  DELETE 	| /course/{:id} 	|                                 EMPTY                                	| Delete a course 	|

# Student Path

| Request 	|      Route     	|                              Body                              	|    Description   	|
|:-------:	|:--------------:	|:--------------------------------------------------------------:	|:----------------:	|
|   GET   	|    /student    	|                              EMPTY                             	| List all student 	|
|   GET   	| /student/{:id} 	|                              EMPTY                             	|   Get a student  	|
|   POST  	|    /student    	|      { name:":name", birthDate:":birthDate" ,age:":age" }      	|   Add a student  	|
|   PUT   	|    /student    	| { id:":id" ,name:":name", birthDate:":birthDate" ,age:":age" } 	| Update a student 	|
|  DELETE 	| /student/{:id} 	|                              EMPTY                             	| Delete a student 	|
