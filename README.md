# To_Do_App


📸 Screenshots
<table>
  <tr>
    <td align="center">
      <img src="https://github.com/baris-gungorr/To_Do_App/blob/main/app/src/main/pic/Screenshot_1696517272.png" alt="TO_DO_APP" width="250">
    </td>
    <td align="center">
      <img src="https://github.com/baris-gungorr/To_Do_App_MVVM/blob/main/app/src/main/pic/2.png" alt="NOTLARIM" width="250">
    </td>
    <td align="center">
      <img src="https://github.com/baris-gungorr/To_Do_App_MVVM/blob/main/app/src/main/pic/3.png" alt="NOTLARIM" width="250">
    </td>

  </tr>
  
</table>

👇 Structures Used

Application architecture: MVVM

- View Binding 
- Coroutine
- ViewModel
- Navigation
- Hilt
- Room

For animation : Lottie used

 ✏️ Dependency
 ```gradle


 implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
 implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

 implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.1")
 implementation("androidx.activity:activity-ktx:1.6.1")

 implementation("com.google.dagger:hilt-android:2.44")
 kapt("com.google.dagger:hilt-android-compiler:2.44")



 implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
 implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

 implementation ("androidx.room:room-runtime:2.5.0-beta02")
 kapt("androidx.room:room-compiler:2.5.0-beta02")
 implementation("androidx.room:room-ktx:2.4.3")
 implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
```

```groovy
plugins {
   id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
```

