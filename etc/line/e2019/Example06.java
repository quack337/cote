package line.e2019;

// 서종현이 메일로 보내준 코딩 테스트 문제
// 전광판 출력하기.
/*
테스트 데이터

 3 Middle
9 149
5 801
7 42
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example06 {
	static final byte[][] LINES = {
			{ 1, 1, 1, 1, 1, 1, 0 }, // 0
			{ 0, 1, 1, 0, 0, 0, 0 }, // 1
			{ 1, 1, 0, 1, 1, 0, 1 }, // 2
			{ 1, 1, 1, 1, 0, 0, 1 }, // 3
			{ 0, 1, 1, 0, 0, 1, 1 }, // 4
			{ 1, 0, 1, 1, 0, 1, 1 }, // 5
			{ 1, 0, 1, 1, 1, 1, 1 }, // 6
			{ 1, 1, 1, 0, 0, 0, 0 }, // 7
			{ 1, 1, 1, 1, 1, 1, 1 }, // 8
			{ 1, 1, 1, 1, 0, 1, 1 }  // 9
	};

	static int height(int size) { // digit 높이
		return size * 2 - 1;
	}

	static char[][] createOutputCanvas(int[] size, String[] number) {
        int width = -1;
        for (int i = 0; i < size.length; ++i)
            width += (size[i] + 1) * number[i].length();
        int height = height(Arrays.stream(size).max().getAsInt());
        return new char[height][width];
	}

	static void drawLine(char[][] canvas, int y1, int x1, int y2, int x2, char ch) {
		if (y1 == y2) // 가로선
			for (int x = x1; x <= x2; ++x) canvas[y1][x] = ch;
		else // 세로선
			for (int y = y1; y <= y2; ++y) canvas[y][x1] = ch;
	}

	static void drawDigit(char[][] canvas, int x1, int size, char ch, char align) {
		int y1 = 0; // Top align
		if (align == 'M') y1 = (canvas.length - height(size)) / 2; // Middle align
		else if (align == 'B') y1 = canvas.length - height(size); // Bottom align
		int y2 = y1 + size - 1, y3 = y1 + (size - 1) * 2, x2 = x1 + size - 1;
		for (int y = 0; y < canvas.length; ++y) // 배경 그리기
			drawLine(canvas, y, x1, y, x2, '.');
		if (LINES[ch - '0'][0] == 1) drawLine(canvas, y1, x1, y1, x2, '#');
		if (LINES[ch - '0'][1] == 1) drawLine(canvas, y1, x2, y2, x2, '#');
		if (LINES[ch - '0'][2] == 1) drawLine(canvas, y2, x2, y3, x2, '#');
		if (LINES[ch - '0'][3] == 1) drawLine(canvas, y3, x1, y3, x2, '#');
		if (LINES[ch - '0'][4] == 1) drawLine(canvas, y2, x1, y3, x1, '#');
		if (LINES[ch - '0'][5] == 1) drawLine(canvas, y1, x1, y2, x1, '#');
		if (LINES[ch - '0'][6] == 1) drawLine(canvas, y2, x1, y2, x2, '#');
	}

	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int count = Integer.parseInt(tokenizer.nextToken());
        char align = tokenizer.nextToken().charAt(0); // Middle, Top, Bottom
        int[] size = new int[count];
        String[] number = new String[count];
        for (int i = 0; i < count; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            size[i] = Integer.parseInt(tokenizer.nextToken());
            number[i] = tokenizer.nextToken();
        }
        char[][] canvas = createOutputCanvas(size, number);
        for (int i = 0, x = 0; i < number.length; ++i)
        	for (int j = 0; j < number[i].length(); ++j, x += size[i] + 1)
        		drawDigit(canvas, x, size[i], number[i].charAt(j), align);
		for (char[] row : canvas)
			System.out.println(new String(row));
	}
}