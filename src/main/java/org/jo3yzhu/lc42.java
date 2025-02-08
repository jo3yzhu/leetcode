package org.jo3yzhu;

import java.util.Stack;

public class lc42 {
    public int trap(int[] height) {
        int total = 0;
        Stack<Integer> indexStack = new Stack<>();
        int leftMost = 0;

        for (int i = 0; i < height.length; ++i) {
            int h = height[i];

            // 新柱子高于上一个柱子，计算水
            while (!indexStack.isEmpty() && h > height[indexStack.peek()]) {
                if (leftMost > h) {
                    for (int index : indexStack) {
                        if (height[index] < h) {
                            total += (h - height[index]);
                            height[index] = h;
                            break;
                        }
                    }
                } else {
                    while (!indexStack.isEmpty()) {
                        int index = indexStack.pop();
                        total += (leftMost - height[index]);
                    }
                }
            }

            // 新柱子低于上一个柱子，累计水
            if (indexStack.isEmpty()) {
                leftMost = height[i];
            }
            indexStack.add(i);
        }

        return total;
    }

    public static void main(String[] args) {
//        System.out.println(new lc42().trap(new int[]{1, 0, 2, 0, 1, 0, 3, 0, 3}));
//        System.out.println(new lc42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(new lc42().trap(new int[]{1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(new lc42().trap(new int[]{0, 7, 1, 4, 6}));
//        System.out.println(new lc42().trap(new int[]{7, 1, 4, 6}));
        for (int i = 0; i < 10000; ++i) {
            System.out.println(new lc42().trap(new int[]{10527,740,9013,1300,29680,4898,13993,15213,18182,24254,3966,24378,11522,9190,6389,32067,21464,7115,7760,3925,31608,16047,20117,239,14254,3647,11664,27710,2374,23076,5655,9035,4725,13013,12690,22900,27252,32431,2234,281,21614,25927,4512,12695,23964,1279,24305,10618,9903,9943,21625,16622,23662,25734,1255,24695,9120,29898,7376,20450,31788,4604,32502,29052,24447,12007,30153,15745,7726,28122,7726,4567,16604,3580,28544,10748,28767,17120,1236,21310,10526,10841,2946,12586,15805,21648,31457,9798,27901,4691,31057,13571,3805,32176,4735,27885,7430,28867,8932,14373,6757,24268,7311,7441,7706,17284,2341,18514,1425,7346,27942,29430,4590,8697,28785,30959,29871,12020,28683,13252,3980,4997,23836,28039,27554,15977,3386,7,11217,30224,24554,29766,32355,5036,23908,13870,20974,29833,12951,12415,20859,5532,11885,25868,27623,3422,9296,21799,27274,22491,22509,20058,23319,10501,22072,28504,20675,14671,24496,31026,16554,16503,18404,16590,32110,4771,28214,21654,5665,5040,13279,10861,7269,29895,4915,27111,5585,28721,15398,9913,7319,30572,23056,8046,29540,1918,26285,21596,4232,6025,11880,2775,25687,21920,27097,4260,24271,9689,4236,21424,30843,6051,18692,8706,17046,17754,6655,9711,17012,21017,16636,29325,7198,31184,20987,13418,20541,26518,1156,23165,4409,17984,20970,19292,29601,16178,18641,31408,32206,23413,14830,29414,23235,31498,8718,10024,13400,22142,30042,8588,30872,16063,12249,24971,3687,3886,20278,32436,15720,1525,6596,25505,19741,30363,22207,13611,8016,2774,23509,14810,18866,1440,5092,21919,29379,15500,25350,28102,30193,15195,3019,18726,4868,17866,31173,16539,11449,11183,5450,21430,23213,9028,1141,30130,21117,7619,32110,9898,27692,18995,3563,11530,17861,14977,31735,836,19009,24274,9203,19908,8106,19224,30682,27941,16513,31459,969,165,17502,1915,7102,27862,7126,1067,5791,14999,17313,29919,14975,25155,13052,4850,15902,22312,2381,21569,942,26427,16134,26756,28893,17161,24011,8414,2063,16881,983,30130,9963,13969,13980,7865,3610,26494,18601,29009,5707,56,22225,31000,13947,3677,8330,32442,16243,24348,16275,28935,28818,20717,730,25673,18892,28031,28828,7124,16115,24562,13262,20958,12341,6983,30908,12689,19431,17685,31984,14175,15745,14461,22101,27542,19945,13663,13724,11060,22772,4046,10207,29436,15402,29634,7044,24777,8905,4365,11365,24355,21261,17297,31533,12048,24751,2991,5125,17452,26795,27395,10353,9980,14919,31054,8308,20864,4433,17843,18171,14855,17832,22567,5497,71,5118,26403,25294,28845,25563,5531,31085,20978,12005,19764,22718,12527,28000,2226,9665,7858,11249,8879,3829,5329,11943,31891,10104,29694,17723,4544,32111,20700,13463,19213,28584,786,22934,9846,1662,10909,26891,1810,21501,8042,28932,16709,8007,32548,32592,14134,24374,19787,4414,6531,18499,22918,12456,8244,29095,24634,25136,20462,21952,6491,18634,8041,12725,10626,8827,4388,2141,10560,608,5464,19549,14003,27633,18474,30097,17750,13191,24612,1454,8221,18460,24806,16421,20930,19026,26137,6474,26457,5303,6821,8373,16683,6472,12324,27368,26049,14388,27286,15923,2879,29666,5206,1749,19188,9780,28237,22116,13102,6926,28773,29295,11091,13330,28224,13921,24109,31150,29739,19624,7814,15705,28749,791,31221,12569,31780,16009,28151,6217,23091,20936,29505,30105,31732,15277,21333,23126,9236,4232,31828,15084,30943,4801,18195,27817,6906,16064,25456,12483,5200,19979,24295,28829,13134,30126,31072,3910,9811,25568,15435,29762,27490,16611,2031,13198,26651,14124,2815,30430,15849,18116,22639,3113,11900,26606,3973,15719,9338,16650,18995,21914,13425,29625,17828,30475,10769,17730,30997,9942,30104,9781,3814,12712,3469,23886,29681,19912,6321,22939,28954,7764,29747,28641,807,31694,27171,1853,25811,9687,11305,30983,32541,16953,26231,10235,13286,19755,32508,4763,14011,24273,21722,25807,26608,27139,5147,19663,26094,22607,29087,5954,18637,10049,25433,22184,15398,27361,10428,6645,27426,22910,14191,30334,29399,17578,24648,26905,20181,9094,16504,21120,29691,4672,21251,4855,3472,27353,13940,2351,4239,23340,31438,30825,6465,7212,3013,6622,18193,11885,2862,23903,2717,16358,12213,7481,6665,7925,31694,18779,32664,24227,24814,19899,30333,4138,8954,14325,2542,13748,4096,24629,10875,21094,24613,6488,11678,15261,20958,11342,27539,3959,22115,8899,28521,29846,25185,9470,27994,1824,14063,28425,29528,5898,14020,8466,2024,7063,7079,28433,11059,27,8230,29611,28250,11781,29067,10838,5387,30748,32268,21695,30034,19209,29506,20329,2481,18198,221,6550,26994,10037,13205,5226,6972,6468,31844,15694,30181,27535,14322,26515,903,13207,19025,14679,6870,21010,8938,28589,8880,30770,15543,11768,13302,4650,28339,23704,3483,15087,8335,23241,3834,7483,14247,1991,11373,26072,20532,26423,4635,11035,5827,25794,26897,28079,21990,31491,29333,5779,3113,16803,28086,5734,7751,9922,31528,2531,31134,22425,29519,1960,15073,7262,25242,31547,11533,11112,8210,12622,13470,14228,12851,31042,31490,15847,30202,32747,28238,22133,15423,18323,26928,3201,20805,24897,5924,485,8848,19259,26859,25013,30454,6345,11578,26143,27897,18236,8623,30101,13140,25647,4104,6959,12244,26893,19351,24138,2153,28627,8945,15734,17021,9495,6631,20623,27780,6986,32695,22057,1493,25402,13699,12337,6328,3546,14593,5074,15040,31558,18293,28822,26459,6914,11484,21198,26791,386,4970,17715,17031,30448,26423,30157,21495,25385,8758,8724,8860,15113,5222,3670,1183,21224,31820,3160,7356,14948,928,21824,23702,1377,29767,15026,334,9807,14721,29498,15955,15788,356}));
        }
    }
}
