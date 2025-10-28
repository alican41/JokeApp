<p align="center">
<!-- DÜZELTME: src özelliği sadece URL'yi içermelidir -->
<img src="https://github.com/user-attachments/assets/8300164d-fc47-4bda-86e6-d5b9ef03d23f" alt="Joke App İkonu" width="128"/>
</p>

Joke App (Yazılımcı Şakaları Uygulaması)

Joke App, Android Kotlin ve Jetpack Compose kullanılarak geliştirilmiş modern bir mobil uygulamadır. Uygulama, MVVM mimarisine uygun olarak tasarlanmış olup, bir JSON API'sinden yazılımcı şakalarını çeker ve kullanıcıya bir liste halinde sunar.

Bu proje, modern Android geliştirme tekniklerini (Compose, ViewModel, StateFlow, Retrofit ve Coroutines) öğrenmek ve uygulamak için harika bir örnektir.

📱 Ekran Görüntüsü

<!--
UYGULAMA EKRAN GÖRÜNTÜNÜZÜ BURAYA EKLEYİN:

Tıpkı ikon gibi, uygulama ekran görüntünüzü (örn: screenshot.png) buraya sürükleyip bırakabilirsiniz.
'width="300"' özniteliği, görselin standart bir telefon ekranı boyutunda görünmesini sağlar ve sayfanın düzenini bozmaz.
-->

<p align="center">
<!-- DÜZELTME: src özelliği sadece URL'yi içermelidir -->
<img src="https://github.com/user-attachments/assets/84e1d691-d266-4bd9-ac4c-8661cbf4e06c" alt="Uygulama Ekran Görüntüsü" width="300"/>
</p>

✨ Temel Özellikler

Modern UI: Tamamen Jetpack Compose ile oluşturulmuş reaktif kullanıcı arayüzü.

MVVM Mimarisi: Sorumlulukların net bir şekilde ayrılması (UI, Business Logic, Data).

API Entegrasyonu: Retrofit kütüphanesi ile uzak API'den veri çekme.

Dinamik Liste: LazyColumn kullanarak API'den gelen tüm şakaları verimli bir şekilde listeleme.

Durum Yönetimi (State Management): ViewModel ve StateFlow kullanarak ekran durumlarını (Yükleniyor, Başarılı, Hata) yönetme.

Dinamik İçerik: Gelen şakanın tipine (single veya twopart) göre farklı Composable'ların gösterilmesi.

Veri Yenileme: Kullanıcının isteği üzerine verilerin API'den tekrar çekilmesi ("Yenile" butonu).

🛠️ Kullanılan Teknolojiler

Dil: Kotlin

UI: Jetpack Compose

Mimari: MVVM (Model-View-ViewModel)

Asenkron Programlama: Kotlin Coroutines

Network: Retrofit 2 & Gson

State Management: ViewModel & StateFlow

👤 Geliştirici

Alican Doğru

GitHub: https://github.com/alican41

E-posta: ali.can.dgru10@gmail.com
