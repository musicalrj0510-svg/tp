========================================
Practical No. 1
======================================= 



 install.packages("party")
library(party)
model <- ctree(Species ~ ., data = iris)
plot(model, type = "simple") 
plot(model)                   


========================================
Practical No. 2
========================================
 
install.packages("wordcloud")
install.packages("RColorBrewer")

 
library(wordcloud)
library(RColorBrewer)

 
words <- c("data","science","mining","analysis","machine","learning",
           "text","widely","interdisciplinary","used","programming",
           "important","field","part")

freq <- c(10,6,6,4,4,4,3,3,3,3,3,2,2)
 
wordcloud(words, freq,
          col = brewer.pal(8, "Dark2"),
          random.order = FALSE)


========================================
Practical No. 3
========================================
 
data <- c(10, 15, 20, 25, 30, 35, 40, 45, 50)
boxplot(data, col="lightgreen", main="Boxplot of data") 
hist(data, col="lightblue", main="Histogram of data", xlab="values")


========================================
Practical No. 4
========================================
 


hours  <- c(1, 2, 3, 4, 5)
scores <- c(50, 55, 65, 70, 75)
 
plot(hours, scores, main="Linear Regression Example",
     xlab="Study Hours", ylab="Scores") 
model <- lm(scores ~ hours)
abline(model, col="blue")


========================================
Practical No. 5
========================================


 
df <- as.data.frame(Titanic) 
titanic.raw <- df[rep(row.names(df), df$Freq), 1:4] 
dim(titanic.raw)        
str(titanic.raw)       
head(titanic.raw)       
summary(titanic.raw)    


========================================
Practical No. 6
=======================================


data(iris)
plot(iris$Sepal.Length,iris$Sepal.Width,col=as.numeric(iris$Species),pch=1,xlab="Sepal.Length",ylab="Sepal.Width")
ct<-aggregate(cbind(Sepal.Length,Sepal.Width)~Species,data=iris,FUN=mean)
points(ct$Sepal.Length,ct$Sepal.Width,col=as.numeric(ct$Species),pch=8,cex=2,lwd=2)



========================================
Practical No. 7
========================================
 
plot(AirPassengers,main="AirPassengers",ylab="Passengers")
plot(c(-25,-35,-5,-10,-5,35,65,65,15,-20,-55,-30),type="o",xaxt="n",xlab="Month",ylab="Value")
axis(1,at=1:12,labels=month.abb)
plot(AirPassengers)
lines(predict(HoltWinters(AirPassengers),n.ahead=12),col="blue",lty=2)




========================================
Practical No. 8
========================================


install.packages("recommenderlab")
library(recommenderlab)
m<-matrix(c(5,NA,3,1,4,2,NA,1,1,2,3,5,NA,3,4,4),nrow=4,byrow=TRUE)
colnames(m)<-c("Item1","Item2","Item3","Item4")
rownames(m)<-c("User1","User2","User3","User4")
r<-as(m,"realRatingMatrix")
print(as(predict(Recommender(r,method="UBCF"),r,n=2),"list"))




========================================
Practical No. 9
========================================




install.packages("isotree")
library(isotree)
d<-data.frame(transactions=c(100,120,130,150,170,200,500,210,220,230))
d$anomaly_score<-predict(isolation.forest(d),d,type="score")
d$anomaly<-ifelse(d$anomaly_score>0.6,"Anomaly","Normal")
print(d)