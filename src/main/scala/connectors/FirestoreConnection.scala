package connectors

import java.io.FileInputStream

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.{ FirebaseApp, FirebaseOptions }
import com.typesafe.config.{ Config, ConfigFactory }

object FirestoreConnection {

  val config: Config = ConfigFactory.load()
  val databaseUrl: String = config.getString("firestore.databaseURL")
  val serviceAccount: FileInputStream = new FileInputStream(config.getString("firestore.keyPath"))

  val options: FirebaseOptions = new FirebaseOptions.Builder()
    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    .setDatabaseUrl(databaseUrl)
    .build()

  FirebaseApp.initializeApp(options)

  val db: Firestore = FirestoreClient.getFirestore

}

