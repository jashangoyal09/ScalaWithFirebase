package scala.firestore
import app.{PersonData, PersonDataBean}
import scala.util.{Failure, Success, Try}
import com.google.cloud.firestore.{CollectionReference, DocumentReference, WriteResult}
import connectors.FirebaseConnection.db

import _root_.scala.util.Try

class FireStorePost {
  var personData = PersonData("A","JAYSON","male")

  def beanToFirestore[B](docId: String, col: CollectionReference, bean: B): Either[String, WriteResult] = {
    val newDocRef: DocumentReference = col.document(docId)
    val tryWrite =
      Try {
        newDocRef.set(bean).get()
      }
    tryWrite match {
      case Failure(ex) => Left(s"error: $ex")
      case Success(v) => Right(v)
    }
  }
  beanToFirestore[PersonDataBean](personData.personId, db.collection("studentdata"), personData.toBean)


}
