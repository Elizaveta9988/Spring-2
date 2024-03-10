package Task12;

@Data
@Entity
@NoArgsConstructor
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    private LocalDateTime localDateTime = LocalDateTime.now();
}