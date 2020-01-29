package Patterns;

public class AdapterApp {
    public static void main(String[] args) {

        // 1. Способ через наследование

        VectorGraphicsInterface vectorGraphicsInterface = new VectorAdapterFromRaster();
        vectorGraphicsInterface.drawLine();
        vectorGraphicsInterface.drawSquare();


        // 2. Способ через композицию
        VectorGraphicsInterface vectorGraphicsInterface2 = new VectorAdapterFromRaster();
        vectorGraphicsInterface2.drawLine();
        vectorGraphicsInterface2.drawSquare();

        // 3. Реализация через конструктор
        VectorGraphicsInterface vectorGraphicsInterface3 = new VectorAdapterFromRaster2(new RasterGraphics());
        vectorGraphicsInterface3.drawLine();
        vectorGraphicsInterface3.drawSquare();
    }


}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    public void drawRasterLine() {
        System.out.println("Рисуем линию");
    }

    public void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{

    RasterGraphics rasterGraphics  = null;

    public VectorAdapterFromRaster2(RasterGraphics rasterGraphics) {
        this.rasterGraphics = rasterGraphics;
    }

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
