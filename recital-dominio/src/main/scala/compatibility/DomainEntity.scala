package compatibility

import org.uqbar.commons.model.Entity

class DomainEntity extends Entity {
  
  def setToList[T](set: Set[T]) : java.util.List[T] = {
    var list : java.util.List[T] = new java.util.ArrayList[T]
    set.foreach(item => list.add(item)) 
    list
  }

  def listToSet[T](list : java.util.List[T]) : Set[T] = {
    var set : Set[T] = Set[T]()
    var iterator = list.iterator()
    while (iterator.hasNext()) {
    	set += iterator.next()
    } 
    set
  }

}