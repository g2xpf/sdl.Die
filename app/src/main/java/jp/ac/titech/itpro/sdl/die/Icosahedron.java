package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Icosahedron implements Obj {
    private final static float a = 0.447213595f;
    private final static float b = 0.276393202f;
    private final static float c = 0.723606797f;
    private final static float d = 0.525731112f;
    private final static float e = 0.850650808f;
    private final static float f = 0.356822089f;
    private final static float g = 0.491123473f;
    private final static float h = 0.491123473f;
    private final static float i = 0.607061998f;
    private final static float j = 0.934172358f;
    private final static float k = 0.303530999f;
    private final static float l = 0.982246946f;
    private final static float m = 0.794654471f;
    private final static float n = 0.187592474f;

    private final static float[] VERTICES = {
            // S0
            .0f, 1.f, .0f, // v0
            .0f, a, a * 2.f, // v1
            e, a, b, // v2

            // S1
            .0f, 1.f, .0f, // v0
            e, a, b, // v2
            d, a, -c, // v3

            // S2
            .0f, 1.f, .0f, // v0
            d, a, -c, // v3
            -d, a, -c, // v4

            // S3
            .0f, 1.f, .0f, // v0
            -d, a, -c, // v4
            -e, a, b, // v5

            // S4
            .0f, 1.f, .0f, // v0
            -e, a, b, // v5
            .0f, a, a * 2.f, // v1

            // S5
            .0f, a, a * 2.f, // v1
            d, -a, c, // v6
            e, a, b, // v2

            // S6
            d, -a, c, // v6
            e, a, b, // v2
            e, -a, -b, // v7

            // S7
            e, a, b, // v2
            e, -a, -b, // v7
            d, a, -c, // v3

            // S8
            e, -a, -b, // v7
            d, a, -c, // v3
            .0f, -a, -2.f * a, // v8

            // S9
            d, a, -c, // v3
            .0f, -a, -2.f * a, // v8
            -d, a, -c, // v4

            // S10
            .0f, -a, -2.f * a, // v8
            -d, a, -c, // v4
            -e, -a, -b, // v9

            // S11
            -d, a, -c, // v4
            -e, -a, -b, // v9
            -e, a, b, // v5

            // S12
            -e, -a, -b, // v9
            -e, a, b, // v5
            -d, -a, c, // v10

            // S13
            -e, a, b, // v5
            -d, -a, c, // v10
            .0f, a, a * 2.f, // v1

            // S14
            -d, -a, c, // v10
            .0f, a, a * 2.f, // v1
            d, -a, c, // v6

            // S15
            .0f, -1.f, .0f, // v11
            d, -a, c, // v6
            e, -a, -b, // v7

            // S16
            .0f, -1.f, .0f, // v11
            e, -a, -b, // v7
            .0f, -a, -2.f * a, // v8

            // S17
            .0f, -1.f, .0f, // v11
            .0f, -a, -2.f * a, // v8
            -e, -a, -b, // v9

            // S18
            .0f, -1.f, .0f, // v11
            -e, -a, -b, // v9
            -d, -a, c, // v10

            // S19
            .0f, -1.f, .0f, // v11
            -d, -a, c, // v10
            d, -a, c, // v6
    };

    private final FloatBuffer vbuf;

    Icosahedron() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // S0
        gl.glNormal3f(f, m, g);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // S1
        gl.glNormal3f(h, m, -n);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // S2
        gl.glNormal3f(0.f, m, -i);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // S3
        gl.glNormal3f(-h, m, -n);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // S4
        gl.glNormal3f(-f, m, g);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // S5
        gl.glNormal3f(h, n, m);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // S6
        gl.glNormal3f(j, -n, k);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // S7
        gl.glNormal3f(j, n, -k);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);

        // S8
        gl.glNormal3f(h, -n, -m);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 24, 3);

        // S9
        gl.glNormal3f(0.f, n, -l);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 27, 3);

        // S10
        gl.glNormal3f(-h, -n, -m);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 30, 3);

        // S11
        gl.glNormal3f(-j, n, -k);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 33, 3);

        // S12
        gl.glNormal3f(-j, -n, k);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 36, 3);

        // S13
        gl.glNormal3f(-h, n, m);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 39, 3);

        // S14
        gl.glNormal3f(.0f, -n, l);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 42, 3);

        // S15
        gl.glNormal3f(h, -m, n);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 45, 3);

        // S16
        gl.glNormal3f(f, -m, -g);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 48, 3);

        // S17
        gl.glNormal3f(-f, -m, -g);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 51, 3);

        // S18
        gl.glNormal3f(-h, -m, n);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 54, 3);

        // S19
        gl.glNormal3f(.0f, -m, i);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 57, 3);
    }
}
