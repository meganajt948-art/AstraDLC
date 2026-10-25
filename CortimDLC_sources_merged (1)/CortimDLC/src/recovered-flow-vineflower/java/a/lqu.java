package a;

import java.util.ArrayList;
import java.util.Collection;

class lqu<E> extends ArrayList<E> {
   private boolean lqv;

   lqu(Collection<E> var1) {
      super(var1);
   }

   @Override
   public int size() {
      if (this.lqv) {
         this.lqv = false;
         return Math.min(super.size(), 100);
      } else {
         return super.size();
      }
   }

   @Override
   public E removeLast() {
      if (super.size() <= lre.lry()) {
         this.lqv = true;
         return this.get(super.size() - 1);
      } else {
         return super.removeLast();
      }
   }
}
