# SHA256 & MD5-Bruteforce-Test
This is a part of my IB Extended Essay project. 
The purpose of this project is to test to what extent does MD5 compare to SHA-256 in terms of efficiency and security.

# Licensing
This repository contains software that was uploaded as my Extended Essay. By article 6 of the [General Regulations of the Diploma Programme](https://www.ibo.org/globalassets/new-structure/become-an-ib-school/pdfs/general-regulations-diploma-programme-en.pdf) the IBO reserves the right to claim a non-exclusive, charge-free, worldwide license, for the duration of the applicable jurisdiction’s copyright. Given that I have completed my Diploma Programme within the Czech Republic which follows the European Copyright Legislation, the IBO holds intellectual property up to 70 years after the authors death. 

As mentioned, the repository holds GPL-3.0 license as well as a non-exclusive, charge-free worldwide license held by the IBO. By using this repository, you are aware of the license regulations mentioned above as well as due diligence.

# Prerequisites
Make sure to either run [JDK 17](https://openjdk.java.net/projects/jdk/17/) or set your java version within the project. Do not go below Java 8.

# How to use
1. Use the ExtendedEssay class, search for "toTest" variable and replace the string with any word you'd like to test. (Do not include special symbols, or allow them within the MD5Bruteforce or SHA256Bruteforce classes)
2. Run the ExtendedEssay class
3. Look at the results. The program should let you know how long it took to hash and bruteforce the ``toTest`` variable.

Helpful tips:
> Make sure that you do not have any extensive background processes running.
> For best results, do run it on a bare-bones linux machine. 
> (Yes, results may vary by a few seconds depending on a lot of [variables](#variables))

# Variables
The results that the code provides will vary based on : 
1. Operating System
2. CPU & RAM usage
3. JDK Version (possibly)
