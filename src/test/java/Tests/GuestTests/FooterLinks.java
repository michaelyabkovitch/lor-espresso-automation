package Tests.GuestTests;

import org.testng.annotations.DataProvider;

public final class FooterLinks {

    @DataProvider(name = "footer-links-and-links-title")
    public Object[][] footerLinks() {
        return new Object[][]{
                {"המחירים באתר אינם כוללים דמי משלוח", "המחירים באתר אינם כוללים דמי משלוח"},
                {"שירות המשלוחים", "משלוחים"},
                {"שאלות נפוצות", "יש לך שאלה?"},
                {"התאמה למכונה", "התאמה למכונה"},
                {"צרו קשר", "יש לך שאלה?"},
                {"נגישות", "נגישות"},
                {"לגלות את עולם הקפה", "לגלות את עולם הקפה"},
                {"לביטול עסקה", "מדיניות ביטול  עסקאות והחלפת מוצרים"},
                {"תנאי משתמש", "תנאי שימוש באתר"},
                {"מדיניות פרטיות", "מדיניות פרטיות"},
                {"מדיניות עוגיות", "מדיניות עוגיות"},
                {"תקנון מבצעים והטבות", "תקנון מבצעים והטבות"}
        };
    }

    @DataProvider(name = "footer-by-links-and-links-title")
    public Object[][] footerByLinks() {
        return new Object[][]{
                {"קפסולות לור (L’OR)", "קפסולות לור (L’OR)"},
                {"קפה ג'ייקובס", "קפה ג'ייקובס"},
                {"ליד הקפה", "ליד הקפה"},
        };
    }
}
