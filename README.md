# Customereriner Spring Web Uygulaması


### Uygulamınn Bazı Özellikleri
* Kullanıcı Eklemek,Güncellemek ve Listelemek.
* Customer Eklemek,Güncellemek,Silmek ve Listelemek.
* Customer adı ya da sahibinin adı ile arama yapmak.
* Unit Test içeriyor.

## Kullandığım Teknolojiler
* Spring
* H2 Database
* Thymeleaf
* Bootstrap
* JPA
* JDK 11
* Maven
* IntelliJ IDE

## Projeye Nasıl Çalıştırılır ?
* Projeyi bu adresten indirmeniz gerekiyor :[proje linki](https://github.com/Furkan-Gunaydinn/SAP_hackathon)
* Projeyi zipten çıkarın.

### IDE Gerekmeden Çalıştırmak İçin:
* Bilgisayarınızda maven kurulu olmalı. Kurulu değil ise buradan kurabilirsiniz: [https://maven.apache.org/download.cgi]
* Pathe tanımlı olmalı. Tanımlı değil ise buradan bakabilirsiniz: [https://mkyong.com/maven/how-to-install-maven-in-windows/]
* Cmd ye ```mvn --version``` yazdığınzda ``` Apache Maven 3.8.4 ``` benzeri bir cevap almalısınız.
* Projeyi zip te ise ziptan çıkartın.
* Daha sonra CMD yi açıp **pom.xml**  in olduğu dizine gelin.
* ```mvn spring-boot:run``` komutunu çalıştırın.
* Aşağıdaki yazıya benzer yazılar geliyorsa proje çalışmıştır :
```
Tomcat started on port(s): 8090 (http) with context path ''  
Started CustomerApplication in 3.574 seconds (JVM running for 3.991)
```

* Tarayıcınız açıp http://localhost:8090/ adresine gidin.

### IntelliJ IDE İle Çalıştırmak İçin:
* Projeyi IntelliJ IDE ile açın.
* ```Run CustomerApplication```
* Run kısmında aşağıdaki yazıya benzer yazılar geliyorsa proje çalışmıştır :
```
Tomcat started on port(s): 8090 (http) with context path ''  
Started CustomerApplication in 3.574 seconds (JVM running for 3.991)
```

* Tarayıcınız açıp http://localhost:8090/ adresine gidin.



