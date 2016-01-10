"""Count words."""

__author__ = 'Rahul Ravindran'

def count_words(s, n):
    """Return the n most frequently occuring words in s."""
    
    # TODO: Count the number of occurences of each word in s
    words = s.split(' ')
    result = {}
    for w in words:
        if w not in result.keys():
            result[w] = 1
        else:
            result[w] = result[w]+1

    results = [(v,k) for v,k in sorted(result.iteritems())]

    
    # TODO: Sort the occurences in descending order (alphabetically in case of ties)

    
    results = sorted(results, key=lambda element: (element[1]), reverse = True)
    
    
    # TODO: Return the top n words as a list of tuples (<word>, <count>)
    top_n = results[:n]
    
    #return top_n
    return top_n

def test_run():
    """Test count_words() with some inputs."""
    print count_words("cat bat mat cat bat cat", 3)
    print count_words("betty bought a bit of butter but the butter was bitter", 3)


if __name__ == '__main__':
    test_run()


