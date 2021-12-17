# 2021 Chingu Holiday Hackathon 

## Project Requirements

For the **Chingu Holiday Hackathon 2021** you'll be creating a game with a purpose - Help Santa deliver presents around the world before the night is over.

As he travels around the world delivering gifts to all the good Software Developers, 60% of the households leave milk & cookies and 40% leave him carrots & tea as snacks. Milk & cookies increase Santa's calories and slow him down, while carrots & tea help him control his weight so he can complete deliveries faster.

For the Holiday Hackathon you'll create an app that assigns a 5000 calorie target for Santa and adds 75 calories for milk & cookies and subtracts 50 calories for carrots & tea. In addition, Santa burns 60 calories for each home he visits. This means there's a net addition of 15 calories for homes who leave him cookies and a net decrease of 10 calories for those that leave him carrots.

Santa can visit 10 homes per second as long as his total nightly calorie intake is below 5000, but only 5 homes per second when it greater than or equal to 5000 calories.

Your app will help Santa monitor his progress by creating a dashboard that's update once per second. This dashboard will display:

- his nightly calorie target
- his total nightly calories accumulated so far
- the total number of homes who have left him milk & cookies
- the total number of homes who have left him carrots & tea
- his current delivery speed as a number of homes per second
- the number of homes visited so far
- the number of homes remaining.

As you might of guessed, Santa believes you can't manage what you don't measure, so he likes metrics!

You will need to allow Santa to input the total number of homes to be visited before the night is over and `Start` and `Stop` buttons.

At the end of the simulation you'll need to display the total time it took him to complete his deliveries.

## To do

### Day 1

- [x] Create a SpringBoot application, add [Vaadin UI framework](https://vaadin.com/start) and [openFeign](https://github.com/OpenFeign/feign) maven dependencies.
- [x] Use `openFeign` to call the Persons API and Books API provided by [Faker API](https://fakerapi.it/en) to get the simulated data.
- [x] Create some entity classes that may be used.
- [x] Use some simple UI components to display on the frontend as test case.
- [x] Write some methods involving game logic.

### Day 2

- [ ] Design a static pages for dashboard.
- [ ] Complete Santa's accumulated calorie calculation.

...

## Programming Process

### Beginning

Create a SpringBoot application. You can customize the initial project from [here](https://start.spring.io/) or start with an IDE, add [Vaadin UI framework](https://vaadin.com/start) maven dependencies. See pom.xml for more details. After that, download it and then import it into IDE.

### Main Logic

### REST web service

I chose REST web service to consume. I thought it's more convenient than using a Database. I found that this is a breeze to implement with [Feign](https://github.com/OpenFeign/feign), so I added Feign maven dependency.

- Data Model

  I needed some POJOs that can hold the data gathered from the REST web service. I parsed the JSON response and selected the data fields I needed to create the classes.

- REST Client

```javascript
@FeignClient(name = "fakerapi",url = "https://fakerapi.it/api/v1")
public interface InfoClient {

    @RequestLine("GET /persons?_quantity={quantity}")
    Response personList(@Param(value = "quantity") int quantity);

    @RequestLine("GET /books?_quantity={quantity}")
    Response bookList(@Param(value = "quantity") int quantity);
}
```

- create some entity classes that may be used.
- use some simple UI components to display on the frontend.
- write some methods involving game logic.

## Conclusion

### Problems & Solution

### Resources





