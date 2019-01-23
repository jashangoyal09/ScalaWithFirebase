package scala.firestore
import app.{PersonData, PersonDataBean}
import com.google.cloud.firestore.{CollectionReference, DocumentSnapshot}
import connectors.FirebaseConnection.db
class FireStoreGet {

  def fetchDocSnapshot(docId: String)(col: CollectionReference): Either[String, DocumentSnapshot] = {
    val docSnapshot = col.document(docId).get().get()
    if (docSnapshot.exists()) Right(docSnapshot) else Left("Something wrong")
  }
  def getSnapshotFromFireStore(docIds: String, collectionName: String): Either[String, DocumentSnapshot] = fetchDocSnapshot(docIds)(db.collection(collectionName))
  val snapshot= getSnapshotFromFireStore("A","persondata")
  val data: Either[String,PersonData] = snapshot.map(value => value.toObject(classOf[PersonDataBean]).toCase)
  def fx(p:PersonData):Unit = {
    println(p)
  }
  data.foreach(fx)

    //data.map(fx)
}
