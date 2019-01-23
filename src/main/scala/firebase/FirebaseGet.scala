package scala.firebase
import connectors.FirebaseConnection._
import com.google.api.core.ApiFuture
import app.{PersonDataBean}
import com.google.cloud.firestore.{QuerySnapshot}

class FirebaseGet {
    val chunk: ApiFuture[QuerySnapshot] = db.collection("persondata").get()
    val chunkSnapshot : QuerySnapshot = chunk.get()
    val data= chunkSnapshot.getDocuments().get(1).toObject(classOf[PersonDataBean]).toCase
    println("Data from firebase " + data)
}
