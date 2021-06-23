# JAVA challenge


## General idea

- There are 3 main functionalities:

1. Get a loan information: recieve a loanID the application should return the information of this loan and the client.
When sending the request the loanId is a @PathVariable

2. Calculate loan metric: the application should calculate the metric according to the type of loan (consumer or student)
In the LoanController given, there are 2 calculateLoanMetric one recieve a loanId and the second one a Loan object. So I made an endpoint for each. I made a GET and a POST 


3. Get the maximun monthly payment loan: for all the loans find the one with the hightest monthly paymennt.

About the 3, in the LoanController originally it should return a Loan object but the example in the documentation looks like this:

```sh
Loan type = consumer
Monthly Rate = 0.005
Monthly Payment = (10000*0.005)/(1-(1+0.005)^-24) = 443.20
```

So I decided to change the controller in order to return this object.

- For getting the maximun monthly payment loan I calculate for each loan the metrics and while doing this I use max to keep track of the highest payment. In this way the complexity is O(n)
I could have use sort descending and get the first element but the complexity would be higher O(n log n).

- For all values that are double I didn't shorten the decimal part as I understand that it's has an impact for the business 
 
- I added a H2 database that once the application start, the AppInitializer is call to load 10 loans using the LoanGeneratonUtil

- For validation I assume the 
 
## Sugestions
- The stack could be build in the cloud
- Infrastructure as code for all the resources
- Create a pipeline with different stages to deploy to prod
- Add automated tests in the pipeline to achieve CI
- Add metrics
- Add alarms on metrics


## Installation

Clone repository from git

```sh
$ git clone https://github.com/rodol86/TrueNorthChallenge.git
$ cd TrueNorthChallenge
```


### Run application directly from jar (Linux: *.sh - Windows: *.bat)

```sh
$ ./start.sh
```

Windows: to stop it, close the console

```sh
$ ./stop.sh
```

### Run application with docker (Linux: *.sh - Windows: *.bat)


```sh
$ ./start_container.sh
```

To stop it

```sh
$ ./stop_container.sh
```

## Usage

### Search by loanID
#### Request
```sh
	curl --location --request GET 'http://localhost:8080/loans/loan/1' \
	--data-raw ''
```

#### Response
```sh
{
    "loanId": 1,
    "requestedAmount": 1000.0,
    "termMonths": 60,
    "annualInterest": 0.1,
    "type": "consumer",
    "borrower": {
        "name": "Borrower 1",
        "age": 23,
        "annualIncome": 150000.0,
        "delinquentDebt": true,
        "annualDebt": 1200.0,
        "creditHistory": 50
    }
}
```

### Calculate Loan Metric by loanID
#### Request
```sh
	curl --location --request GET 'http://localhost:8080/loans/loan/LoanMetric/1' \
	--data-raw ''
```

#### Response
```sh
{
    "monthlyInterestRate": 8.333333333333333E-5,
    "monthlyPayment": 16.709062488873897
}
```

### Calculate Loan Metric by loanID
#### Request
```sh
	curl --location --request POST 'http://localhost:8080/loans/loan/LoanMetric' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "loanId": 1,
	    "requestedAmount": 1000.0,
	    "termMonths": 60,
	    "annualInterest": 0.1,
	    "type": "consumer",
	    "borrower": {
	        "name": "Borrower 1",
	        "age": 23,
	        "annualIncome": 150000.0,
	        "delinquentDebt": true,
	        "annualDebt": 1200.0,
	        "creditHistory": 50
	    }
	}'

```

#### Response
```sh
{
    "monthlyInterestRate": 8.333333333333333E-5,
    "monthlyPayment": 16.709062488873897
}
```

### Calculate Loan Metric by loanID
#### Request
```sh
	curl --location --request GET 'http://localhost:8080/loans/MaxMonthlyPaymentLoan' \
	--data-raw ''

```

#### Response
```sh
{
    "loan": {
        "loanId": 10,
        "requestedAmount": 10000.0,
        "termMonths": 36,
        "annualInterest": 0.18181818181818182,
        "type": "student",
        "borrower": {
            "name": "Borrower 10",
            "age": 23,
            "annualIncome": 150000.0,
            "delinquentDebt": true,
            "annualDebt": 1200.0,
            "creditHistory": 50
        }
    },
    "monthlyInterestRate": 1.5151515151515152E-4,
    "monthlyPayment": 222.84566834207794
}
```

