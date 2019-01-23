package connectors

import java.io.FileInputStream

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.database.{DatabaseReference, FirebaseDatabase}
import com.google.firebase.{FirebaseApp, FirebaseOptions}
import com.typesafe.config.{Config, ConfigFactory}

object FirebaseConnection {

  val config: Config = ConfigFactory.load()
  private val serviceAccount: FileInputStream = new FileInputStream(config.getString("firebase.keyPath"))
//  private val serviceAccount: FileInputStream = new FileInputStream("serviceAccountCredentials.json")

  private val options = new FirebaseOptions.Builder()
    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    .setDatabaseUrl(config.getString("firebase.databaseURL"))
    .build()

//  private val options = new FirebaseOptions.Builder()
//    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//    .setDatabaseUrl("https://trial-8aa0a.firebaseio.com")
//    .build()

  FirebaseApp.initializeApp(options)

  private val database = FirebaseDatabase.getInstance()

  def ref(path: String): DatabaseReference = database.getReference().child(path)
  val db: Firestore = FirestoreClient.getFirestore

}
