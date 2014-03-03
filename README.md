bloom-filter
============

Bloom filter implementation written in Java.

This project was a part of the Bioinformatics class at FER, Croatia.

## Included

### Bloom Filters:

- Bloom Filter
- Partitioned Bloom Filter
- Scalable Bloom Filter

### Hash Functions:
- Fowler–Noll–Vo (32 bit)
- Fowler–Noll–Vo-1a (32 bit)
- MurmurHash3 (32 bit)

## Additional info
The use of <em>n</em> hash functions is simulated using the expression: h<sub>i</sub>=h<sub>1</sub>+i*h<sub>2</sub>

## Useful Resources
<a href="http://en.wikipedia.org/wiki/Bloom_filter">Bloom filter on Wikipedia</a>
<a href="http://gsd.di.uminho.pt/members/cbm/ps/dbloom.pdf">Paper about Scalable Bloom Filters</a>
<a href="http://citeseer.ist.psu.edu/viewdoc/download;jsessionid=4060353E67A356EF9528D2C57C064F5A?doi=10.1.1.152.579&rep=rep1&type=pdf">Simulate <em>n</em> hash functions by <em>two</em> hash functions</a>
<a href="http://en.wikipedia.org/wiki/Fowler%E2%80%93Noll%E2%80%93Vo_hash_function">Fowler–Noll–Vo on Wikipedia</a>
<a href="http://www.isthe.com/chongo/tech/comp/fnv/index.html">Fowler-Noll-Vo: Official page</a>
<a href="http://en.wikipedia.org/wiki/MurmurHash">MurmurHash on Wikipedia</a>
