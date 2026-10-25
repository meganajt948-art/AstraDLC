package a;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class tvq {
   public float sprintShare;
   public float walkBreakShare;
   public float turnCap;
   public float turnRate;
   public float blocksPerMin;
   public float oresPerMin;
   public float farmPerMin;
   public float activeRate;
   public float activeDia;
   public float workShare;
   public float seconds;
   public int hits;
   public int reactionMs;

   public boolean sprints() {
      return this.sprintShare >= 0.4F;
   }

   public boolean walkMines() {
      return this.walkBreakShare >= 0.25F;
   }

   void write(DataOutputStream var1) throws IOException {
      var1.writeFloat(this.sprintShare);
      var1.writeFloat(this.walkBreakShare);
      var1.writeFloat(this.turnCap);
      var1.writeFloat(this.turnRate);
      var1.writeFloat(this.blocksPerMin);
      var1.writeFloat(this.oresPerMin);
      var1.writeFloat(this.farmPerMin);
      var1.writeFloat(this.activeRate);
      var1.writeFloat(this.activeDia);
      var1.writeFloat(this.workShare);
      var1.writeFloat(this.seconds);
      var1.writeInt(this.hits);
      var1.writeInt(this.reactionMs);
   }

   static tvq read(DataInputStream var0) throws IOException {
      tvq var1 = new tvq();
      var1.sprintShare = var0.readFloat();
      var1.walkBreakShare = var0.readFloat();
      var1.turnCap = var0.readFloat();
      var1.turnRate = var0.readFloat();
      var1.blocksPerMin = var0.readFloat();
      var1.oresPerMin = var0.readFloat();
      var1.farmPerMin = var0.readFloat();
      var1.activeRate = var0.readFloat();
      var1.activeDia = var0.readFloat();
      var1.workShare = var0.readFloat();
      var1.seconds = var0.readFloat();
      var1.hits = var0.readInt();
      var1.reactionMs = var0.readInt();
      return var1;
   }
}
