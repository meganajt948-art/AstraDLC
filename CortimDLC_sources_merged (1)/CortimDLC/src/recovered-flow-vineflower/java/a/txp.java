package a;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class txp {
   public float speed;
   public float sprintShare;
   public float jumpsPerMin;
   public float turnMedian;
   public float turnP99;
   public float pitchMean;
   public float lateralMean;
   public float strafeShare;
   public float seconds;
   public float meters;
   public int routes;

   void write(DataOutputStream var1) throws IOException {
      var1.writeFloat(this.speed);
      var1.writeFloat(this.sprintShare);
      var1.writeFloat(this.jumpsPerMin);
      var1.writeFloat(this.turnMedian);
      var1.writeFloat(this.turnP99);
      var1.writeFloat(this.pitchMean);
      var1.writeFloat(this.lateralMean);
      var1.writeFloat(this.strafeShare);
      var1.writeFloat(this.seconds);
      var1.writeFloat(this.meters);
      var1.writeInt(this.routes);
   }

   static txp read(DataInputStream var0) throws IOException {
      txp var1 = new txp();
      var1.speed = var0.readFloat();
      var1.sprintShare = var0.readFloat();
      var1.jumpsPerMin = var0.readFloat();
      var1.turnMedian = var0.readFloat();
      var1.turnP99 = var0.readFloat();
      var1.pitchMean = var0.readFloat();
      var1.lateralMean = var0.readFloat();
      var1.strafeShare = var0.readFloat();
      var1.seconds = var0.readFloat();
      var1.meters = var0.readFloat();
      var1.routes = var0.readInt();
      return var1;
   }
}
