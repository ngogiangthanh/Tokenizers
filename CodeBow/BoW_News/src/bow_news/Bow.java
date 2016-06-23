package bow_news;

/**
 *
 * @author Ti-Hon Nguyen, Thanh-Nghi Do (CTU)
 */
interface Bow {

    public void splitter(); //prototype

    public void remover_stop();

    public void to_libsvm();

    public void vnsplitter();

    public void vnto_libsvm();

    public void toBoW();
}
