# validicCode

The coding challenge instructions can be found at : https://gist.github.com/wbates/848f0b398656929baac7d63cd975ae75


**Questions:** 

**challenges you ran into**

One of the early challenges in this code kata is that there wasn't a "language" heading in the JSON object returned by the Github API. However, it isn't uncommon for APIs to return JSON objects that are disorganizd. Ergo, instead of being able to automatically populate the languages via AJAX with the @JSONProperty("Language") annotation on a jobSummary model, I had to create a different json object for each langauage and count IDs.


**areas of the code you are most proud of**

I'm most proud of the fact that the code follows a clear MVC architecture. This makes the program decoupled and much more resistant to the ever changing requirements of customers via the agile model. It does implement a microservice ("DataSummaryService") which can be built upon to include other metrics as necessary, as well as changing the view.    


**areas of the code you are least proud of**

One of the areas I'm not particularly happy with is that the DataSummaryService has one function that performs all of the analyses on the data in question. This is okay for the problem that we're trying to solve, but one should always write programs with an eye towards the future needs of the business. If I were doing this as an enterprise level production at work, I would anticipate that the analyses conducted would eventually become more than one metric. Ergo, it would probably make a lot more sense to write it in such a fashion that I could reuse some of the data across multiple methods (such as the total amount of jobs, or saving a list off of each mention of each job type." 


**tradeoffs you made and why**

The biggest trade off here is that I had to work with the limitations of the API. Specifically, I had to decide whether or not I was going to make an individual GET request for each specific language to the url in question OR perform a single GET request and go through the data. The tradeoff is that, if I were to perform multiple calls for each language, I could employ the search feature within the API instead of having to spin my own. However, I actually conducted manual performance tests on both, and felt that making mutliple GET requests for each individual language was going to be too expensive of a process. Instead, the GithubController just makes a single call to the city in question and returns all the data as a single JSON objecct. The DataSummaryService then goes through the results and splits them into specific jobs. It then goes through each job and determines which languages are mentioned.



**next areas of focus to move this towards production**

The next area to focus on is going into the DataSummaryService and changing the way in which it stores the ratios of languages mentioned in the job listings. This way it can be more adequately tested (see the commented out unit test in DataSummaryServiceShould). 
