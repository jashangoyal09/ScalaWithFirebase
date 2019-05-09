package scala.firebase
import app.PersonData
import com.google.api.core.ApiFuture
import connectors.FirebaseConnection

class FireBasePost {
  val personData=PersonData("B","jashan","male")

  def post(personData: PersonData, refPath: String): ApiFuture[Void] = {
    val ref = FirebaseConnection.ref(refPath).child(personData.personId)
    ref.setValueAsync(personData.toBean)
  }

  private def parseAsPersonData(personData: PersonData): PersonData = {
    PersonData(personData.personId, personData.personName, personData.personGender)
  }

  val personDataBean = parseAsPersonData(personData)
  post(personDataBean, "studentDetails")

  def get[T](personData: T, refPath: String, key: String): ApiFuture[Void] = {
    val ref = FirebaseConnection.ref(refPath).child(key)
    ref.setValueAsync(personData)
  }

  private def parseAsPersonDataBean(personData: PersonData): PersonData = {
    PersonData(personData.personId, personData.personName, personData.personGender)
  }
  val personDataNormal = parseAsPersonData(personData).toBean




}
