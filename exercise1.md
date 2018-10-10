# Exercise 1

## How to recreate
Report is available in pmd-collected.csv, created by running runpmd.sh.

## Chosen checks
For each check only the first occurrence will be listed. Checks are listed in perceived order of importance, from most to least important.

### ConstructorCallsOverridableMethod
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\main\java\org\crygier\graphql\GraphQLExecutor.java" Priority 1, Line 54 
	Ruleset: Error Prone, Description:"Overridable method 'createGraphQL' called during object construction" 
	#### I have chosen this check, because calling an overridable method in a constructor may have unintended consequences in Java due to inheritance, where a child may not initialize correctly due to an override. I found 3 of these errors.

### GuardLogStatement
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\main\java\org\crygier\graphql\JavaScalars.java" Priority: 2, Line: 141,
	 Ruleset:"Best Practices", Description:"There is log block not surrounded by if"
	#### I have chosen this check because Log statements used for debugging should always be guarded. This makes it easier to eliminate them when preparing the software for release, to avoid junk printing to the command line, and increase performance.

### MissingSerialVersionUID
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\test\groovy\org\crygier\graphql\model\embeddings\EmbeddingId.java", Priority: 3, Line: 13,
	Ruleset: Error Prone, Description: "Classes implementing Serializable should set a serialVersionUID"
	#### This rule is very important, since java relies on serialVersionUID to ensure that an object is being serialized and deserialized with the same version of its code.

### AvoidDuplicateLiterals
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\main\java\org\crygier\graphql\JavaScalars.java", Priority: 3, Line: 25    
	Ruleset: "Error Prone" , Description: "The String literal 'Date type' appears 4 times in this file; the first occurrence is on line 25"
	#### This check was chosen because duplicating string literals makes it very easy to forget to update all occurrences when making a change, resulting in inconsistent behavior and presentation, as well as being time-consuming to hunt down.
	#### To alleviate this problem, strings can be kept in external resource files, rather than embedded in code.

### EmptyCatchBlock
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\main\java\org\crygier\graphql\GraphQLSchemaBuilder.java", Priority: 3, Line: 281   
	Description: "Avoid empty catch blocks", Ruleset: "Error Prone"
	#### This one is quite likely to be a sign of bad code, because in almost all cases, it is desirable to know whether an operation failed, so that the correct course can be taken.  with your variables afterwards.

### UnusedFormalParameter
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\main\java\org\crygier\graphql\JpaDataFetcher.java", Priority: 3, Line: 158, 
	Description: "Avoid unused method parameters such as 'argument'.", Ruleset: "Best Practices"
	#### I chose this one, because unused method parameters unnecessarily complicates and obfuscates code interfaces, making it very hard to predict how code will behave based on its signature.

### UnusedImports
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\main\java\org\crygier\graphql\JpaDataFetcher.java", Priority: 4, Line: 3,     
	Ruleset: "Best Practices" Description: "Avoid unused imports such as 'graphql.language'", 
	#### This check was chosen because unused imports make it hard to discern the real dependencies for a file, and introduces unnecessary compile-time overhead. Also this seems to be a common problem in the graphjql-jpa codebase.
	
###	OptimizableToArrayCall
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\main\java\org\crygier\graphql\ExtendedJpaDataFetcher.java", Priority: 3, Line: 65,
	Description: "This call to Collection.toArray() may be optimizable", Ruleset:"Performance"
	I chose this last one because as far as I can tell, it tries to detect when an undeclared array is passed to ToArray(), resulting in an immediate resize. 
	#### This is unnecessary and takes time. However, in this specific example, the sizing seems to be correct from the start, so I found this check interesting.

### UnusedPrivateField
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\test\groovy\org\crygier\graphql\model\embeddings\EmbeddingTest.java", Priority: 3, Line: 16,
	Description: "Avoid unused private fields such as 'embeddingId'.", Ruleset: "Best Practices"
	#### I chose this one because it is a code smell that is simply not necessary. A class should only have the fields it needs, and no more. However, I would consider it less serious than "UnusedFormalParameter", since it only affects "black-boxed" code

###  BeanMembersShouldSerialize
"C:\Users\krist\Documents\cphbusiness\UFO\graphql-jpa\src\test\groovy\org\crygier\graphql\model\embeddings\EmbeddingId.java", Priority: 3, Line: 17,
	Description: "Found non-transient [...] non-static member. Please mark as transient or provide accessors.", Ruleset: "Error Prone"
	#### This check means a Serializable class has incorrectly forgottent to mark a non-persistent variable as transient. This is a hint to prevent java from serializing data that will go unused later. This is a simple optimization, but requires a little more thought than just serializing all members regardless.
	
##Exercise 2
	Unfortunately, I was unable to get Netbeans to attach the profiler to tests as they were running, and I couldn't figure out microbenchmarking with Groovy :(