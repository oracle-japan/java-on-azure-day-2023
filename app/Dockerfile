FROM eclipse-temurin:19-jdk-alpine as build
WORKDIR /helidon
COPY . .
RUN ./mvnw package -DskipTests
RUN echo "done!"

FROM eclipse-temurin:19-jre-alpine
WORKDIR /helidon
COPY --from=build /helidon/target/app.jar ./
COPY --from=build /helidon/target/libs ./libs
CMD ["java", "--enable-preview", "-jar", "app.jar"]
EXPOSE 8080
