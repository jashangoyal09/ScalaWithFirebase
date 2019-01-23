package  app
import scala.beans.BeanProperty
class PersonDataBean() {
  @BeanProperty var personId: String = _
  @BeanProperty var personName: String = _
  @BeanProperty var personGender: String = _
  def toCase: PersonData = {
    PersonData(personId, personName, personGender)
  }
}

case class PersonData(
  personId: String,
  personName: String,
  personGender: String) {
  def toBean: PersonDataBean = {
    val personData = new PersonDataBean()
    personData.personId = personId
    personData.personName = personName
    personData.personGender = personGender
    personData
  }
}
